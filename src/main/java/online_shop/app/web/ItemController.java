package online_shop.app.web;

import online_shop.app.models.binding.ItemAddBindingModel;
import online_shop.app.models.service.ItemServiceModel;
import online_shop.app.models.service.UserServiceModel;
import online_shop.app.models.view.ItemViewModel;
import online_shop.app.service.ItemService;
import online_shop.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/items")
@Transactional
public class ItemController {
    private final ModelMapper modelMapper;
    private final ItemService itemService;

    public ItemController(ModelMapper modelMapper, ItemService itemService) {
        this.modelMapper = modelMapper;
        this.itemService = itemService;
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("itemAddBindingModel")) {
            model.addAttribute("itemAddBindingModel", new ItemAddBindingModel());
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("itemAddBindingModel") ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:/items/add";
        }
        this.itemService.addItem(this.modelMapper.map(itemAddBindingModel, ItemServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") String id, ModelAndView modelAndView) {
        modelAndView.addObject("item", this.itemService.findById(id));
        modelAndView.setViewName("details-item");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        System.out.println();
        UserServiceModel user = (UserServiceModel) httpSession.getAttribute("user");
        ItemViewModel item = this.itemService.findById(id);
        if (user.getBudget().doubleValue() > item.getPrice().doubleValue()) {
            this.itemService.delete(user, item);
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("notEnoughBudget", true);
            return "redirect:/items/details/{id}";
        }

    }

}

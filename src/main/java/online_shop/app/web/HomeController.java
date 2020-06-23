package online_shop.app.web;

import online_shop.app.models.service.ItemServiceModel;
import online_shop.app.models.view.ItemViewModel;
import online_shop.app.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public ModelAndView index(@Valid @ModelAttribute("itemServiceModel") ItemServiceModel itemServiceModel, ModelAndView modelAndView, HttpSession httpSession) {


        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            List<ItemViewModel> items = itemService.findAllItems();
            modelAndView.addObject("items", items);
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}

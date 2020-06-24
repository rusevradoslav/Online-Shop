package online_shop.app.web;

import online_shop.app.models.binding.UserLoginBindingModel;
import online_shop.app.models.binding.UserRegisterBindingModel;
import online_shop.app.models.service.UserServiceModel;
import online_shop.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model) {

        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute("userLoginBindingModel") UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession
    ) {
        System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",bindingResult);
            return "redirect:/users/login";
        }
        UserServiceModel user = this.userService.getUserByUsername(userLoginBindingModel.getUsername());


        if (user == null || !user.getPassword().equals(userLoginBindingModel.getPassword())) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        } else {
            httpSession.setAttribute("user", user);
            return "redirect:/";

        }

    }

    @GetMapping("/register")
    public String register(Model model) {

        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:/users/register";
        }

        UserServiceModel user = this.userService.getUserByUsername(userRegisterBindingModel.getUsername());

        if (user == null || userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {

            this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
            return "redirect:/users/login";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}

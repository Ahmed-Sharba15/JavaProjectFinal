package superMarketWeb;

import org.springframework.data.repository.query.Param;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "Home";
    }

    @GetMapping("Register")
    public String getRegisterPage() {
        return "Register";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.insertCustomer(customer);
        return "redirect:/all";
    }

    @GetMapping("/all")
    public String getAll(Model model,@Param("keyword") Long keyword){
        List<Customer> list=customerService.getAllCustomers(keyword);
        model.addAttribute("customers",list);
        model.addAttribute("keyword", keyword);
        return "CustomerList";
    }
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return "redirect:/all";
    }


    @RequestMapping("/update/{id}")
    public String UpdateCustomer(@PathVariable Long id, Model model){
        Customer custom = customerService.getCustomerById(id);
        model.addAttribute("customer" , custom);
        return "updateCustomer";  //view name
    }
    @GetMapping("About")
    public String getAboutPage() {
        return "About";

    }

}

package brandonjuliothenaro.blog;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

	@Autowired
	BlogRepository blogRepo;

	// -------------------------
	// Create
	// -------------------------

    @GetMapping("/get_create")
    public String getCreate(Model model) {
    	model.addAttribute("blog", new Blog());
    	return "create";
    }

    @PostMapping("/post_create")
    public String postCreate(@Valid @ModelAttribute Blog newBlog, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
    	if (bindingResult.hasErrors()) {
    		return "create";
    	}

    	blogRepo.save(newBlog);
    	redirectAttrs.addFlashAttribute("announcement", "Blog created.");
    	return "redirect:/";
    }

    // -------------------------
	// Read
	// -------------------------

    @RequestMapping("/")
    public String all(Model model) {
    	model.addAttribute("blogs", blogRepo.findAll());
        return "index";
    }

    @GetMapping("/{blogId}")
    public String one(Model model, @PathVariable Long blogId) {
    	model.addAttribute("blog", blogRepo.findById(blogId).get());
    	return "view";
    }

	// -------------------------
	// Update
	// -------------------------

    @GetMapping("/{blogId}/get_edit")
    public String getEdit(Model model, @PathVariable Long blogId) {
    	model.addAttribute("blog", blogRepo.findById(blogId).get());
    	return "edit";
    }

    @PostMapping("/post_edit")
    public String postEdit(@Valid @ModelAttribute Blog updatedBlog, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
    	if (bindingResult.hasErrors()) {
    		return "edit";
    	}

    	blogRepo.save(updatedBlog);
    	redirectAttrs.addFlashAttribute("announcement", "Blog edited.");
    	return "redirect:/" + updatedBlog.getId();
    }

	// -------------------------
	// Delete
	// -------------------------

    @PostMapping("/{blogId}/delete")
    public String delete(@PathVariable Long blogId, RedirectAttributes redirectAttrs) {
    	blogRepo.deleteById(blogId);
    	redirectAttrs.addFlashAttribute("announcement", "Blog deleted.");
    	return "redirect:/";
    }

}

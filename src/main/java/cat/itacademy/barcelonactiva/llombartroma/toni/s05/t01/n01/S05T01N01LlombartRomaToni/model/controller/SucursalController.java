package cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.controller;

import cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
 @Controller
    public class SucursalController {
        @Autowired
        private SucursalService sucursalService;
        @GetMapping(value={"/home","/"})
        public String index() {
            return "home";
        }

        @GetMapping(value={"/sucursals/newClient","/sucursals/newClient/"})
        public String create(Model model) {
            SucursalDTO sucursalDTO = new SucursalDTO();
            sucursalDTO.setSucursalType();
            model.addAttribute("title","Form: new sucursal");
            model.addAttribute("sucursal",sucursalDTO);
            return "add";
        }
        /* Handles adding sucursal requests */
        @PostMapping("/sucursals/add")
        public String add(@ModelAttribute SucursalDTO sucursalDTO) {
            sucursalService.add(sucursalDTO);
            return "redirect:/sucursals";
        }

        /* Handles updating sucursal requests */
        @GetMapping(value={"/sucursals/update/{id}","/sucursals/update/{id}/"})
        public String update(@PathVariable("id") int id, Model model) {
            SucursalDTO sucursalDTO = sucursalService.getOne(id).get();
            sucursalDTO.setSucursalType();
            model.addAttribute("title","Form: edit sucursal");
            model.addAttribute("sucursal",sucursalDTO);
            return "add";
        }
        /* Handles deleting sucursals requests */
        @GetMapping(value={"/sucursals/delete/{id}","/sucursals/delete/{id}/"})
        public String delete(@PathVariable("id") int id) {
            sucursalService.delete(id);
            System.out.println("Sucursal successfully deleted");
            return "redirect:/sucursals";
        }
        /* Handles retrieving one sucursal requests */
        @GetMapping("/sucursals/search")
        public String search(@RequestParam("name") String name, Model model) {
            List<SucursalDTO> searchResults = sucursalService.searchSucursalByName(name).get();
            model.addAttribute("title", "Search Results");
            model.addAttribute("sucursals", searchResults);
            return "getAll";
        }

     /* Handles retrieving all sucursals requests */
        @GetMapping(value={"/sucursals","/sucursals/"})
        public String getAll(Model model) {
            List<SucursalDTO> sucursals = sucursalService.getAll().get();
            model.addAttribute("title", "Sucursals list");
            model.addAttribute("sucursals", sucursals);
            return "getAll";
        }
    }

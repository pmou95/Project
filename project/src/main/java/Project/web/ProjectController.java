package Project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Project.domain.*;

@Controller
public class ProjectController {
	@Autowired
	private PlayerRepo prepo; 

	@Autowired
	private PositionRepo orepo; 
	


    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	


    @RequestMapping(value="/playerlist")
    public String playerList(Model model) {	
        model.addAttribute("players", prepo.findAll());
        return "playerlist";
    }
  

    @RequestMapping(value="/players")
    public @ResponseBody List<Player> playerListRest() {	
        return (List<Player>) prepo.findAll();
    }    


    @RequestMapping(value="/player/{id}", method = RequestMethod.GET)
    public @ResponseBody Player findPlayerRest(@PathVariable("id") Long playerId) {	
    	return prepo.findOne(playerId);
    }       
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addPlayer(Model model){
    	model.addAttribute("player", new Player());
    	model.addAttribute("position", orepo.findAll());
        return "addplayer";
    }     
    
   
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Player player){
        prepo.save(player);
        return "redirect:playerlist";
    }    

   
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
    	prepo.delete(playerId);
        return "redirect:../playerlist";
    }     
}

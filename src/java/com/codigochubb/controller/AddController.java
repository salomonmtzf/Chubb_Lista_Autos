package com.codigochubb.controller;

import com.codigochubb.modelos.Conectar;
import com.codigochubb.modelos.Autos;
import com.codigochubb.modelos.UsuariosValidar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("add.htm")
public class AddController {
    
    UsuariosValidar usuariosValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AddController()
    {
    this.usuariosValidar=new UsuariosValidar();
    Conectar con=new Conectar();
    this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("autos",new Autos());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
             @ModelAttribute("autos") Autos u,
             BindingResult result,
             SessionStatus status
        )
                
    {
        this.usuariosValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("add");
            mav.addObject("autos",new Autos());
            return mav;
        }else
        {
        this.jdbcTemplate.update
        (
        "insert into autos(marca,cantidad,inventario) values (?,?,?)",
        u.getMarca(),u.getCantidad(),u.getInventario()
        );
        return new ModelAndView("redirect:/home.htm");
        }
        
    }
}

package com.codigochubb.controller;


import com.codigochubb.modelos.Conectar;
import com.codigochubb.modelos.Autos;
import com.codigochubb.modelos.UsuariosValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("edit.htm")
public class EditController 
{
    UsuariosValidar usuariosValidar;
    private JdbcTemplate jdbcTemplate;
    
    public EditController()
    {
    this.usuariosValidar=new UsuariosValidar();
    Conectar con=new Conectar();
    this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request)
    {
    ModelAndView mav=new ModelAndView();
    int id=Integer.parseInt(request.getParameter("id"));
    Autos datos=this.selectAutos(id);
    mav.setViewName("edit");
    mav.addObject("autos",new Autos(id,datos.getMarca(),datos.getCantidad(),datos.getInventario()));
    return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
       (
        @ModelAttribute("autos") Autos u,
        BindingResult result,
        SessionStatus status,
        HttpServletRequest request
       )
    {
       this.usuariosValidar.validate(u, result);
       if(result.hasErrors())
    {
        ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        Autos datos=this.selectAutos(id);
        mav.setViewName("edit");
        mav.addObject("autos", new Autos(id,datos.getMarca(),datos.getCantidad(),datos.getInventario()));
        return mav;
    }else
    {
     int id=Integer.parseInt(request.getParameter("id"));
     this.jdbcTemplate.update(
        "update autos "
        +"set marca=?,"
        +"cantidad=?,"
        +"inventario=? "
        +"where "
        +"id=?",
     u.getMarca(),u.getCantidad(),u.getInventario(),id);
     return new ModelAndView("redirect:/home.htm");            
    }
   }
    public Autos selectAutos(int id)
    {
    final Autos user = new Autos();
    String quer = "SELECT * FROM autos WHERE id=' " + id + " ' ";
    return (Autos) jdbcTemplate.query
        (quer, new ResultSetExtractor<Autos>()
    {
        public Autos extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()){
                user.setMarca(rs.getString("marca"));
                user.setCantidad(rs.getString("cantidad"));
                user.setInventario(rs.getString("inventario"));
            }
            return user;
        }
    }
        );
    }
}

   


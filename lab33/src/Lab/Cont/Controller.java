package Lab.Cont;

import Lab.DAO.GoodsDAO;
import Lab.Mod.GoodsM;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


import java.sql.SQLException;
import java.util.List;


@org.springframework.stereotype.Controller
@RequestMapping(value = "/goods")
public class Controller {
 private  GoodsDAO goodsDAO;
    @Autowired
 public void setGoodsDAO(GoodsDAO goodsDAO) {
    this.goodsDAO = goodsDAO;
 }

    @RequestMapping(value = "/index")
    public String showAll(Model model){
        List<GoodsM>goodsMList = null;
        try {
            goodsMList = goodsDAO.getAll();
        } catch (SQLException e) {
            return "redirect:/error";
        }
        model.addAttribute("list", goodsMList);
        return "index";
    }

    @RequestMapping(value = "getOne/{id}")
    public String showOne(@PathVariable(value = "id") int id, Model model){
        GoodsM goodsM = null;
        try {
            goodsM = goodsDAO.getById(id);
        } catch (SQLException e) {
            return "redirect:/error";
        }
        model.addAttribute("item", goodsM);
        return "details";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        try {
            goodsDAO.delete(id);
        } catch (SQLException e) {
            return "redirect:/error";
        }
        return "redirect:/goods/index";
    }

    @RequestMapping(value = "/addNewForm")
    public String addNewForm(Model model){
        try{
            model.addAttribute("command", new GoodsM());
            return "AddGoods";
        }catch (Exception e){
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public String addNew(@ModelAttribute(value = "command") GoodsM goodsM){
        try {
            goodsDAO.add(goodsM);
        } catch (SQLException e) {
            return "redirect:/error";
        }
        return  "redirect:/goods/index";
    }

    @RequestMapping(value = "modifyForm/{id}")
    public String modifyForm(@PathVariable(value = "id") int id, Model model) {
        GoodsM goodsM = null;
        try {
            goodsM = goodsDAO.getById(id);
            model.addAttribute("item", goodsM);
            return "modify";
        } catch (SQLException e) {
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(@ModelAttribute(value = "item") GoodsM goodsM){
        try {
            goodsDAO.update(goodsM);
            return "redirect:/goods/index";
        } catch (SQLException e) {
            return "error";
        }
    }
}
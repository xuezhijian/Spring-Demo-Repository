package cn.xuezhijian2.demo.test.primary.controller;

import cn.xuezhijian2.demo.test.primary.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.controller
 * User         : zj
 * Date         : 17/4/18
 * Time         : 下午9:22
 * Description  :
 */

@RestController
@RequestMapping("/primary/city")
public class CityController {

    @Autowired
    private CityService cityService;

//    @RequestMapping cities
//    public PageInfo<City> getAll(City city) {
//        List<City> countryList = cityService.getAll(city);
//        return new PageInfo<City>(countryList);
//    }
//
//    @RequestMapping(value = "/add")
//    public City add() {
//        return new City();
//    }
//
//    @RequestMapping(value = "/view/{id}")
//    public City view(@PathVariable Integer id) {
//        ModelAndView result = new ModelAndView();
//        City city = cityService.getById(id);
//        return city;
//    }
//
//    @RequestMapping(value = "/delete/{id}")
//    public ModelMap delete(@PathVariable Integer id) {
//        ModelMap result = new ModelMap();
//        cityService.deleteById(id);
//        result.put("msg", "删除成功!");
//        return result;
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelMap save(City city) {
//        ModelMap result = new ModelMap();
//        String msg = city.getId() == null ? "新增成功!" : "更新成功!";
//        cityService.save(city);
//        result.put("city", city);
//        result.put("msg", msg);
//        return result;
//    }

}

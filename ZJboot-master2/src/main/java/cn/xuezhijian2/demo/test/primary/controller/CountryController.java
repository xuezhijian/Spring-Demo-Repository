package cn.xuezhijian2.demo.test.primary.controller;

import cn.xuezhijian2.core.dto.ResultDataDto;
import cn.xuezhijian2.demo.test.primary.entity.Country;
import cn.xuezhijian2.demo.test.primary.service.CountryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.test.controller
 * User         : zj
 * Date         : 17/4/18
 * Time         : 下午9:24
 * Description  :
 */

@Controller
@RequestMapping("/primary/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/getAllByPage",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public PageInfo<Country> getAllByPage() {
        List<Country> countryList = countryService.getAllByPage(0,5);
        return new PageInfo<Country>(countryList);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResultDataDto add() {
        Country country = new Country();
        country.setCountryname("Zambia");
        country.setCountrycode("ZM");
        countryService.add(country);
        return ResultDataDto.addAddSuccess();
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResultDataDto delete(@PathVariable Integer id) {
        countryService.delete(id);
        return ResultDataDto.addDeleteSuccess();
    }

    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Country query(@PathVariable Integer id) {
        Country country = countryService.query(id);
        System.out.println(country);
        return country;
    }

    @RequestMapping(value = "/update/{id}.",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResultDataDto update(@PathVariable Integer id) {

        Country country = countryService.query(id);
        if(country == null){
            return new ResultDataDto("300","该id的country不存在");
        }

        country.setCountryname("测试");
        country.setCountrycode("CS");
        countryService.update(country);
        return ResultDataDto.addUpdateSuccess();
    }

}

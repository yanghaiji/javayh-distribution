package com.javayh.api.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javayh.common.util.DataResult;
import com.javayh.conf.dto.SysUserDTO;
import com.javayh.conf.dto.SysUserSerchDTO;
import com.javayh.conf.dto.UserModfiyPwdDTO;
import com.javayh.conf.entity.SysUser;
import com.javayh.conf.service.UserService;
import com.javayh.conf.util.log.OperationType;
import com.javayh.conf.util.log.WebLogAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dylan Yang
 * @Description: 用户相关操作
 * @ProjectName javayh-distribution
 * @date 2019-10-30 23:22
 */
@Controller
@RequestMapping("/javayh")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 来到添加用户页面
     * @return
     */
    @RequestMapping("/adduser")
    public String touser() {
        return "user/register";
    }

    /**
     * @Description 查询用户信息  后期需要在改
     * @UserModule: javayh-distribution
     * @author Dylan
     * @date 2019/10/31
     * @param pn
     * @param model
     * @return java.lang.String
     */
    @GetMapping("/alluser_admin")
    public String getAllUser(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             SysUserSerchDTO dto, Model model) {
        PageHelper.startPage(pn, 4);
        List<SysUser> u_list = userService.getAllPageUser(dto);
        PageInfo<SysUser> page = new PageInfo<>(u_list, 3);
        model.addAttribute("pageInfo", page);
        return "user/users";
    }

    /**
     * @Description 新增用户
     * @UserModule: javayh-distribution
     * @author Dylan
     * @date 2019/10/31
     * @param user
     * @return com.javayh.common.util.DataResult
     */
    @PostMapping("/saveUser")
    @ResponseBody
    @WebLogAspect(detail = "新增用户",level = 2,operationType = OperationType.SELECT)
    public DataResult addUser(SysUser user) {
        int i = userService.saveUser(user);
        return i == 1 ?DataResult.success():DataResult.error();
    }

    /**
     * @Description 得到用户个人信息
     * @UserModule: javayh-distribution
     * @author Dylan
     * @date 2019/11/1
     * @param username
     * @param model
     * @return java.lang.String
     */
    @GetMapping("/user")
    public String getUser(@RequestParam("username")String username,Model model) {
        SysUserDTO user=userService.getUserByName(username);
        model.addAttribute("user", user);
        return "user/myInfo";
    }

    /**
     * @Description 更新数据回显
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/11/1
     * @param username
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("/toUpdatepage")
    public String toUpdatePage(@RequestParam("username")String username,Model model) {
        SysUserDTO user=userService.getUserByName(username);
        model.addAttribute("user", user);
        return "user/editPage";
    }

    /**
     * @Description 修改用户信息
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/11/1
     * @param user
     * @return com.javayh.common.util.DataResult
     */
    @PutMapping("/userUpdate")
    @ResponseBody
    public DataResult updateUser(SysUser user) {
        userService.updateUser(user);
        return DataResult.success();
    }

    /**
     * @Description 删除用户
     * @UserModule: javayh
     * @author Dylan
     * @date 2019/11/2 0002
     * @param [id]
     * @return com.javayh.common.util.DataResult
     */
    @DeleteMapping(value = "delete")
    @ResponseBody
    public DataResult delete(int id) {
        userService.delete(id);
        return DataResult.success();
    }

    /**
     * @Description 修改密码
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/11/1
     * @param user
     * @return com.javayh.common.util.DataResult
     */
    @PutMapping("/updatePwd")
    @ResponseBody
    public DataResult updateUserPwd(UserModfiyPwdDTO user) {
        int i = userService.updateUserPwd(user);
        return i == 0 ? DataResult.error(): DataResult.success();
    }
}

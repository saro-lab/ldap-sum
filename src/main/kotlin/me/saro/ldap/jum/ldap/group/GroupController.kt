package me.saro.ldap.jum.ldap.group

import me.saro.commons.Converter
import me.saro.ldap.jum.ldap.LdapService
import me.saro.ldap.jum.props.PropsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/group")
class GroupController {

    @Autowired lateinit var ldapService: LdapService

    @GetMapping("/")
    fun root(model: Model): String {
        model.addAttribute("groups", ldapService.getGroups())
        // aa
        return "group/index"
    }

    @GetMapping("/list")
    @ResponseBody
    fun list() : String {
        println(ldapService.getGroups())
        return Converter.toJson(ldapService.getGroups())
    }



}

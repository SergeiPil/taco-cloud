package com.piliugin.tacocloud.controller;

import com.piliugin.tacocloud.model.security.User;
import com.piliugin.tacocloud.service.OrderAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final OrderAdminService adminService;

    public AdminController(OrderAdminService orderAdminService) {
        this.adminService = orderAdminService;
    }

    @GetMapping
    public String admin() {
        return "admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/deleteAllOrders")
    public String deleteAllOrders(@AuthenticationPrincipal User user) {
        log.info("user grants -> {}", user.getAuthorities());
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }
}

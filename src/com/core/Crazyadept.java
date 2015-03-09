package com.core;

import javax.servlet.http.HttpSession;

import com.model.User;

public class Crazyadept {
    public Crazyadept() {
    }

    public static boolean UserIsOK(HttpSession session, int status) {
        User u = (User) session.getAttribute("user");
        if (u == null || u.getUid() == null || "".equals(u.getUid()) ||
            u.getStatus() != status ) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean UserIsOK(HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u == null || u.getUid() == null || "".equals(u.getUid())) {
            return false;
        } else {
            return true;
        }
    }
  }

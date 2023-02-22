package org.example.tv.tcl;

import org.example.tv.api.ITv;

/**
 * tcl电视
 *
 * @author gongmin
 * @date 2023/2/22 14:52
 */
public class TclTv implements ITv {
    @Override
    public void turnOn() {
        System.out.println("欢迎使用TCL");
    }

    @Override
    public void turnOff() {
        System.out.println("欢迎下次再次使用TCL");
    }

    @Override
    public String getBrand() {
        return "tcl";
    }
}

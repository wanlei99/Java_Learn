package com.wl.pojo;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.16$
 * @Param 地址类$
 * @return $
 */
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}

package com.kln.module_usercenter.bean;


import java.util.List;

public class GetPageListBean{
    /**
     * total : 172
     * totalPage : null
     * items : [{"id":1115,"name":"HTC","image":"","letter":"H"},{"id":1528,"name":"LG","image":"","letter":"L"},{"id":1912,"name":"NEC","image":"","letter":"N"},{"id":2032,"name":"OPPO","image":"http://img10.360buyimg.com/popshop/jfs/t2119/133/2264148064/4303/b8ab3755/56b2f385N8e4eb051.jpg","letter":"O"},{"id":2505,"name":"TCL","image":"","letter":"T"},{"id":3177,"name":"爱贝多","image":"","letter":"A"},{"id":3539,"name":"安桥（ONKYO）","image":"","letter":"A"},{"id":3941,"name":"白金（PLATINUM）","image":"","letter":"B"},{"id":4986,"name":"波导（BiRD）","image":"","letter":"B"},{"id":6522,"name":"朵唯（DOOV）","image":"","letter":"D"},{"id":6742,"name":"飞利浦（PHILIPS）","image":"http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg","letter":"F"},{"id":7174,"name":"富可视（InFocus）","image":"","letter":"F"},{"id":7203,"name":"富士通（Fujitsu）","image":"","letter":"F"},{"id":7420,"name":"格力（GREE）","image":"","letter":"G"},{"id":7817,"name":"海尔（Haier）","image":"http://image.leyou.com/group1/M00/00/00/wKg4ZVrYZcyAVOzoAAB846UcmLg013.png","letter":"H"}]
     */

    private int total;
    private Object totalPage;
    private List<ItemsBean> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Object totalPage) {
        this.totalPage = totalPage;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id : 1115
         * name : HTC
         * image :
         * letter : H
         */

        private int id;
        private String name;
        private String image;
        private String letter;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLetter() {
            return letter;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }
    }
}

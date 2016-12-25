package com.example.chenjunmei.shoppingguide.bean;

import java.util.List;

/**
 * Created by ChenJunMei on 2016/11/25.
 */

public class WomenBean {

    private WomenData data;
    private String info;
    private int status;

    public WomenData getData() {
        return data;
    }

    public void setData(WomenData data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class WomenData {

        private String id;
        private String name;
        private String title;
        private String is_delete;
        private String create_time;
        private String page;
        private UpdateNumBean updateNum;
        private List<ModuleBean> module;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIs_delete() {
            return is_delete;
        }

        public void setIs_delete(String is_delete) {
            this.is_delete = is_delete;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public UpdateNumBean getUpdateNum() {
            return updateNum;
        }

        public void setUpdateNum(UpdateNumBean updateNum) {
            this.updateNum = updateNum;
        }

        public List<ModuleBean> getModule() {
            return module;
        }

        public void setModule(List<ModuleBean> module) {
            this.module = module;
        }

        public static class UpdateNumBean {
            /**
             * productNum : 642
             * specialNum : 8
             */

            private int productNum;
            private int specialNum;

            public int getProductNum() {
                return productNum;
            }

            public void setProductNum(int productNum) {
                this.productNum = productNum;
            }

            public int getSpecialNum() {
                return specialNum;
            }

            public void setSpecialNum(int specialNum) {
                this.specialNum = specialNum;
            }
        }

        public static class ModuleBean {


            private String id;
            private String c_title;
            private String e_title;
            private String module_key;
            private String sort;
            private String is_more;
            private String more_jump_id;
            private JumpBean jump;
            private List<DataBean> data;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getC_title() {
                return c_title;
            }

            public void setC_title(String c_title) {
                this.c_title = c_title;
            }

            public String getE_title() {
                return e_title;
            }

            public void setE_title(String e_title) {
                this.e_title = e_title;
            }

            public String getModule_key() {
                return module_key;
            }

            public void setModule_key(String module_key) {
                this.module_key = module_key;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getIs_more() {
                return is_more;
            }

            public void setIs_more(String is_more) {
                this.is_more = is_more;
            }

            public String getMore_jump_id() {
                return more_jump_id;
            }

            public void setMore_jump_id(String more_jump_id) {
                this.more_jump_id = more_jump_id;
            }

            public JumpBean getJump() {
                return jump;
            }

            public void setJump(JumpBean jump) {
                this.jump = jump;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class JumpBean {
                /**
                 * id : 219625
                 * type : 103
                 * is_h5 : 0
                 * url :
                 * tid :
                 * jump_type : 103
                 */

                private String id;
                private String type;
                private String is_h5;
                private String url;
                private String tid;
                private String jump_type;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getIs_h5() {
                    return is_h5;
                }

                public void setIs_h5(String is_h5) {
                    this.is_h5 = is_h5;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTid() {
                    return tid;
                }

                public void setTid(String tid) {
                    this.tid = tid;
                }

                public String getJump_type() {
                    return jump_type;
                }

                public void setJump_type(String jump_type) {
                    this.jump_type = jump_type;
                }
            }

            public static class DataBean {

                private String title;
                private String jump_id;
                private String replace_param;
                private String img;
                private String sort;
                private String module_id;
                private JumpBeanX jump;
                ///////////////
                private String price_tag;
                private String product_price;

                ////////////////

                public String getPrice_tag() {
                    return price_tag;
                }

                public void setPrice_tag(String price_tag) {
                    this.price_tag = price_tag;
                }

                public String getProduct_price() {
                    return product_price;
                }

                public void setProduct_price(String product_price) {
                    this.product_price = product_price;
                }



                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getJump_id() {
                    return jump_id;
                }

                public void setJump_id(String jump_id) {
                    this.jump_id = jump_id;
                }

                public String getReplace_param() {
                    return replace_param;
                }

                public void setReplace_param(String replace_param) {
                    this.replace_param = replace_param;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getSort() {
                    return sort;
                }

                public void setSort(String sort) {
                    this.sort = sort;
                }

                public String getModule_id() {
                    return module_id;
                }

                public void setModule_id(String module_id) {
                    this.module_id = module_id;
                }

                public JumpBeanX getJump() {
                    return jump;
                }

                public void setJump(JumpBeanX jump) {
                    this.jump = jump;
                }

                public static class JumpBeanX {

                    private String id;
                    private String name;
                    private String type;
                    private String is_h5;
                    private String url;
                    private String tid;
                    private String ext;
                    private String jump_type;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getIs_h5() {
                        return is_h5;
                    }

                    public void setIs_h5(String is_h5) {
                        this.is_h5 = is_h5;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getTid() {
                        return tid;
                    }

                    public void setTid(String tid) {
                        this.tid = tid;
                    }

                    public String getExt() {
                        return ext;
                    }

                    public void setExt(String ext) {
                        this.ext = ext;
                    }

                    public String getJump_type() {
                        return jump_type;
                    }

                    public void setJump_type(String jump_type) {
                        this.jump_type = jump_type;
                    }
                }
            }
        }
    }
}

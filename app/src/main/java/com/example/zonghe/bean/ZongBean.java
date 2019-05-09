package com.example.zonghe.bean;

import java.util.List;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 15:30
 * update: $date$
 */
public class ZongBean {
        /**
         * result : [{"masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/4/1.jpg","price":99,"commodityId":89,"saleNum":0,"commodityName":"森马毛呢外套女士简约气质西装领短款呢子大衣韩版"},{"masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/1/1.jpg","price":199,"commodityId":86,"saleNum":0,"commodityName":"韩版装冬装春秋冬小清新学院风皮毛一体翻领短款加绒加厚机车服夹克外套"},{"masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/6/1.jpg","price":509,"commodityId":91,"saleNum":0,"commodityName":"冬季新品女款长款派克棉服"},{"masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/3/1.jpg","price":358,"commodityId":88,"saleNum":0,"commodityName":"冬新品 梵希蔓毛呢外套女短款长袖2018冬季新款宽松英伦格子翻领斜门襟大衣女"},{"masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/5/1.jpg","price":396,"commodityId":90,"saleNum":0,"commodityName":"女款气质女神斗篷披肩蝙蝠衫毛呢外套"}]
         * message : 查询成功
         * status : 0000
         */
        private List<ResultEntity> result;
        private String message;
        private String status;

        public void setResult(List<ResultEntity> result) {
            this.result = result;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<ResultEntity> getResult() {
            return result;
        }

        public String getMessage() {
            return message;
        }

        public String getStatus() {
            return status;
        }

        public class ResultEntity {
            /**
             * masterPic : http://172.17.8.100/images/small/commodity/nz/wt/4/1.jpg
             * price : 99
             * commodityId : 89
             * saleNum : 0
             * commodityName : 森马毛呢外套女士简约气质西装领短款呢子大衣韩版
             */
            private String masterPic;
            private int price;
            private int commodityId;
            private int saleNum;
            private String commodityName;

            public void setMasterPic(String masterPic) {
                this.masterPic = masterPic;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public void setSaleNum(int saleNum) {
                this.saleNum = saleNum;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getMasterPic() {
                return masterPic;
            }

            public int getPrice() {
                return price;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public int getSaleNum() {
                return saleNum;
            }

            public String getCommodityName() {
                return commodityName;
            }
        }


}

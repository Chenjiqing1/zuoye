package com.example.zonghe.bean;

import java.util.List;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/5 15:30
 * update: $date$
 */
public class RightBean {

        /**
         * result : [{"name":"外套","id":"1001002001"},{"name":"裙装","id":"1001002002"},{"name":"打底毛衣","id":"1001002003"},{"name":"卫衣","id":"1001002004"},{"name":"裤装","id":"1001002005"}]
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
             * name : 外套
             * id : 1001002001
             */
            private String name;
            private String id;

            public void setName(String name) {
                this.name = name;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public String getId() {
                return id;
            }
        }
    }


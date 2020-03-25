package test.testactive.domain;

public enum  DeliveryStatus {

        READY("준비중"),
        SHIPPING("배달중") ,
        ARRIVE("도착"),
        CANCEL("취소"),
        SUCCESS("리뷰를 달아주세요");

        private String status;

        DeliveryStatus(String status) {
                this.status = status;
        }

        public String getStatus() {
                return status;

        }

}


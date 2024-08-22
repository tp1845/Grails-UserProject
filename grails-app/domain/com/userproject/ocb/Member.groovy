package com.userproject.ocb

class Member {
    Integer id
    String firstName
    String lastName
    String email
    String password
    String identityHash
    Long identityHashLastUpdate
    Boolean isActive = true
    String memberType = GlobalConfig.USER_TYPE.REGULAR_MEMBER

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        lastName(nullable: true)
        identityHash(nullable: true)
        identityHashLastUpdate(nullable: true)
    }

//    events declare
    def beforeInsert (){
        this.password = this.password.encodeAsMD5()
    }


    def beforeUpdate(){
        this.password = this.password.encodeAsMD5()
    }
}

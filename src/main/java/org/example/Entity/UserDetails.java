    package org.example.Entity;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.RequiredArgsConstructor;
    import lombok.Setter;

    @AllArgsConstructor
    @RequiredArgsConstructor
    @Getter
    @Setter
    @Entity
    @Table(name="user_details")
    public class UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "userid")
        private Integer userId;

        @Column(name = "name")
        private String name;

    //    @Column(name = "loginid")
    //    private String loginId;

        @Column(name = "password")
        private String password;

        @Column(name = "email")
        private String email;

        @Column(name = "phone")
        private String phone;

        @Column(name = "xstatus")
        private Integer xstatus;

        @Column(name = "isactive")
        private Integer isactive;

        @Column(name = "usertypeid")
        private Integer userTypeId;
    }

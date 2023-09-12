package com.zhsq;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZhsqApplicationTests {

    /*@Autowired
    private UserDao userDao;
    @Test
    void testAdd(){
        User userTable=new User();
        userTable.setUsername("ymyacc");
        userTable.setPassword("123456");
        userTable.setUser("yangmaoying");
        userTable.setUserImage("image.jpg");
        userTable.setUserType(0);
        userTable.setEmail("2360@qq.com");
        userTable.setPhoneNumber("19117610824");
        userDao.insert(userTable);
    }
    @Test
    void testDel(){
        userDao.deleteById(927010817L);
    }

    @Test
    void updateId(){
        User userTable=new User();
        userTable.setUsername("ymyacc");
        userTable.setPassword("123456");
        userTable.setUser("ymy");
        userTable.setId(1700126384573136897L);
        userDao.updateById(userTable);
    }
    @Test
    void testGetAll() {
        //条件查询
        QueryWrapper qw=new QueryWrapper();
        qw.lt("id",3);
        List<User> users = userDao.selectList(qw);
        for (User user : users) {
            System.out.println(user);
        }
    }
    *//*
     *条件查询2
     *//*
    @Test
    void Lambda1(){
        QueryWrapper<User> qw=new QueryWrapper();
        qw.lambda().lt(User::getId,3);
        List<User> users = userDao.selectList(qw);
        for (User user : users) {
            System.out.println(user);
        }
    }
    *//*
     *条件查询3
     *//*
    @Test
    void Lambda2(){
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.lt(User::getId,3);//小于
        List<User> users = userDao.selectList(lqw);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void Lambda3(){
        *//*UserQuery uq=new UserQuery();
        uq.setUserType(0);
        uq.setUserType2(2);
        //null判断
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.lt(User::getId,3);//小于
        lqw.ge(User::getId,1);//大于
        List<User> users = userDao.selectList(lqw);*//*
        *//*LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.select(User::getId,User::getEmail,User::getPassword);
        List<User> users = userDao.selectList(lqw);
        for (User user : users) {
            System.out.println(user);
        }*//*
        *//*QueryWrapper<User> lqw=new QueryWrapper<>();
        lqw.select("count(*) as count,user_image");
        lqw.groupBy("user_image");
        List<Map<String, Object>> maps = userDao.selectMaps(lqw);
        System.out.println(maps);*//*

        //带条件查询等比
        *//*LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.eq(User::getPhoneNumber,"15314970030").eq(User::getPassword,"123456");
        User Loginuser = userDao.selectOne(lqw);
        System.out.println(Loginuser);*//*
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        //范围查询lt le，gt ge，eq，between
        //lqw.between(User::getId,1,5);//前小后大
        //模糊匹配
        //lqw.like(User::getUsername,"林");//Left左Right右加%
        List<User> users = userDao.selectList(lqw);
        System.out.println(users);
    }
    @Test
    void testPage(){
        Page page = userDao.selectPage(new Page(1, 2), null);
        System.out.println("num:"+page.getCurrent());
        System.out.println("data:"+page.getRecords());
    }
*/

}

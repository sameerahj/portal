diff --git a/.gitignore b/.gitignore
index 3e672ac..a941638 100644
--- a/.gitignore
+++ b/.gitignore
@@ -38,4 +38,4 @@ ehthumbs.db
 Thumbs.db
 
 .idea/
-target/
+*/target/
diff --git a/pom.xml b/pom.xml
index dfa9191..21835bd 100644
--- a/pom.xml
+++ b/pom.xml
@@ -10,7 +10,6 @@
     <packaging>war</packaging>
     <name>Dhara Portal</name>
     <dependencies>
-
         <dependency>
             <groupId>junit</groupId>
             <artifactId>junit</artifactId>
@@ -24,7 +23,6 @@
             <version>3.0.1</version>
             <scope>provided</scope>
         </dependency>
-
         <!--
             Core utilities used by other modules.
             Define this if you use Spring Utility APIs (org.springframework.core.*/org.springframework.util.*)
@@ -175,13 +173,11 @@
             <artifactId>mysql-connector-java</artifactId>
             <version>5.1.10</version>
         </dependency>
-
         <dependency>
             <groupId>org.hibernate</groupId>
             <artifactId>hibernate-core</artifactId>
             <version>4.2.1.Final</version>
         </dependency>
-
         <!-- JSTL -->
         <dependency>
             <groupId>javax.servlet</groupId>
@@ -200,56 +196,47 @@
             <artifactId>axis2-kernel</artifactId>
             <version>1.6.2</version>
         </dependency>
-
         <dependency>
-            <groupId>org.apache.axis2</groupId>
-            <artifactId>axis2-adb</artifactId>
-            <version>1.6.2</version>
+        <groupId>org.apache.axis2</groupId>
+        <artifactId>axis2-adb</artifactId>
+        <version>1.6.2</version>
         </dependency>
-
         <dependency>
             <groupId>org.apache.axis2</groupId>
             <artifactId>axis2-codegen</artifactId>
             <version>1.6.2</version>
         </dependency>
-
         <dependency>
             <groupId>org.apache.axis2</groupId>
             <artifactId>axis2-transport-http</artifactId>
             <version>1.6.2</version>
         </dependency>
-
         <dependency>
             <groupId>org.apache.axis2</groupId>
             <artifactId>axis2-transport-local</artifactId>
             <version>1.6.2</version>
         </dependency>
-
         <dependency>
             <groupId>org.apache.axis2</groupId>
             <artifactId>axis2-java2wsdl</artifactId>
             <version>1.6.2</version>
         </dependency>
-
         <dependency>
             <groupId>org.apache.ws.commons.axiom</groupId>
             <artifactId>axiom-api</artifactId>
             <version>1.2.14</version>
         </dependency>
-
         <dependency>
             <groupId>org.apache.ws.commons.axiom</groupId>
             <artifactId>axiom-impl</artifactId>
             <version>1.2.14</version>
             <scope>runtime</scope>
         </dependency>
-
         <dependency>
             <groupId>com.google.code.gson</groupId>
             <artifactId>gson</artifactId>
             <version>2.2.2</version>
         </dependency>
-
         <!-- Workflow Invoker-->
         <dependency>
             <groupId>org.apache.airavata</groupId>
@@ -262,7 +249,6 @@
                 </exclusion>
             </exclusions>
         </dependency>
-
         <dependency>
             <groupId>org.apache.airavata</groupId>
             <artifactId>airavata-client-api</artifactId>
@@ -274,7 +260,6 @@
                 </exclusion>
             </exclusions>
         </dependency>
-
         <dependency>
             <groupId>org.apache.airavata</groupId>
             <artifactId>airavata-registry-api</artifactId>
@@ -295,9 +280,10 @@
 
     </dependencies>
 
+
     <!-- Shared version number properties -->
     <properties>
-        <org.springframework.version>3.2.3.RELEASE</org.springframework.version>
+        <org.springframework.version>3.0.5.RELEASE</org.springframework.version>
         <slf4jVersion>1.6.1</slf4jVersion>
         <airavataVersion>0.8-SNAPSHOT</airavataVersion>
     </properties>
@@ -316,44 +302,9 @@
                     <target>1.5</target>
                 </configuration>
             </plugin>
-            <plugin>
-                <artifactId>maven-resources-plugin</artifactId>
-                <version>2.4.3</version>
-                <executions>
-                    <execution>
-                        <id>copy-resources</id>
-                        <!-- here the phase you need -->
-                        <phase>process-resources</phase>
-                        <goals>
-                            <goal>copy-resources</goal>
-                        </goals>
-                        <configuration>
-                            <outputDirectory>target/portal/WEB-INF</outputDirectory>
-                            <resources>
-                                <resource>
-                                    <directory>src/main/resources</directory>
-                                    <filtering>true</filtering>
-                                </resource>
-                            </resources>
-                        </configuration>
-                    </execution>
-                </executions>
-            </plugin>
         </plugins>
     </build>
     <repositories>
-        <repository>
-            <id>n52-snapshots</id>
-            <name>n52-snapshots</name>
-            <url>http://52north.org/maven/repo/snapshots/</url>
-            <snapshots>
-                <enabled>true</enabled>
-            </snapshots>
-        </repository>
-        <repository>
-            <id>springsource-repo</id>
-            <name>SpringSource Repository</name>
-            <url>http://repo.springsource.org/release</url>
-        </repository>
+
     </repositories>
 </project>
diff --git a/src/main/java/org/dhara/portal/web/codegen/WPSTemplate.java b/src/main/java/org/dhara/portal/web/codegen/WPSTemplate.java
deleted file mode 100644
index 28746b3..0000000
--- a/src/main/java/org/dhara/portal/web/codegen/WPSTemplate.java
+++ /dev/null
@@ -1,18 +0,0 @@
-package org.dhara.portal.web.codegen;
-
-import java.util.ArrayList;
-
-/**
- * Created with IntelliJ IDEA.
- * User: harsha
- * Date: 7/9/13
- * Time: 8:13 PM
- * To change this template use File | Settings | File Templates.
- */
-public class WPSTemplate {
-    private ArrayList<String> imports=new ArrayList<String>();
-    private ArrayList<String> inputs=new ArrayList<String>();
-    private ArrayList<String> outputs=new ArrayList<String>();
-
-
-}
diff --git a/src/main/java/org/dhara/portal/web/controllers/HellowWorldController.java b/src/main/java/org/dhara/portal/web/controllers/HellowWorldController.java
index 10eadd8..5535ab5 100644
--- a/src/main/java/org/dhara/portal/web/controllers/HellowWorldController.java
+++ b/src/main/java/org/dhara/portal/web/controllers/HellowWorldController.java
@@ -8,18 +8,14 @@ package org.dhara.portal.web.controllers;
  * To change this template use File | Settings | File Templates.
  */
 
+
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
-import org.dhara.portal.web.springHibernateSample.entity.Customer;
-import org.dhara.portal.web.springHibernateSample.service.UserService;
-import org.springframework.context.ApplicationContext;
-import org.springframework.web.context.support.WebApplicationContextUtils;
 import org.springframework.web.servlet.ModelAndView;
 import org.springframework.web.servlet.mvc.AbstractController;
 
 import java.util.Date;
-import java.util.List;
 
 public class HellowWorldController extends AbstractController{
 
@@ -28,19 +24,6 @@ public class HellowWorldController extends AbstractController{
                                                  HttpServletResponse response) throws Exception {
         String now = (new Date()).toString();
         logger.info("Returning hello view with " + now);
-
-        ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
-        UserService service=(UserService)context.getBean("userService");
-        Customer customer=new Customer();
-        customer.setName("Abc");
-        customer.setAddress("DDC");
-        customer.setItem("aoaoaaoa");
-
-        service.saveOrUpdateCustomer(customer);
-
-        List<Customer> customerList = service.fetchALLCustomers();
-
-        request.setAttribute("customerData", customerList);
-        return new ModelAndView("helloworld", "now", customerList.get(0).getId());
+        return new ModelAndView("helloworld", "now", now);
     }
 }
diff --git a/src/main/java/org/dhara/portal/web/springHibernateSample/dao/HibernateUserDao.java b/src/main/java/org/dhara/portal/web/springHibernateSample/dao/HibernateUserDao.java
index dc99caa..bbf8a88 100644
--- a/src/main/java/org/dhara/portal/web/springHibernateSample/dao/HibernateUserDao.java
+++ b/src/main/java/org/dhara/portal/web/springHibernateSample/dao/HibernateUserDao.java
@@ -1,11 +1,8 @@
 package org.dhara.portal.web.springHibernateSample.dao;
 
-import org.dhara.portal.web.springHibernateSample.entity.Customer;
-import org.hibernate.Criteria;
+import org.dhara.portal.web.springHibernateSample.entity.User;
 import org.hibernate.SessionFactory;
-import org.springframework.transaction.annotation.Transactional;
-
-import java.util.List;
+import org.springframework.beans.factory.annotation.Autowired;
 
 /**
  * Created with IntelliJ IDEA.
@@ -14,27 +11,17 @@ import java.util.List;
  * Time: 1:04 PM
  * To change this template use File | Settings | File Templates.
  */
-@Transactional
 public class HibernateUserDao implements UserDao {
-
+    @Autowired(required=true)
     private SessionFactory sessionFactory;
 
-    public void saveOrUpdateCustomer(Customer customer) {
-        getSessionFactory().getCurrentSession().save(customer);
-    }
-
-    public List<Customer> fetchALLCustomers() {
-        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Customer.class);
-        return (List<Customer>) criteria.list();
+    public User findById(Long id) {
+        return (User) this.sessionFactory.getCurrentSession().createQuery(
+                "from User user where user.id=?").setParameter(0, id)
+                .uniqueResult();
     }
 
-    public SessionFactory getSessionFactory() {
-        return sessionFactory;
-    }
-
-    public void setSessionFactory(SessionFactory sessionFactory) {
-        this.sessionFactory = sessionFactory;
+    public User persistOrMerge(User user) {
+        return (User) this.sessionFactory.getCurrentSession().merge(user);
     }
 }
-
-
diff --git a/src/main/java/org/dhara/portal/web/springHibernateSample/dao/UserDao.java b/src/main/java/org/dhara/portal/web/springHibernateSample/dao/UserDao.java
index 512aa6a..59c8c20 100644
--- a/src/main/java/org/dhara/portal/web/springHibernateSample/dao/UserDao.java
+++ b/src/main/java/org/dhara/portal/web/springHibernateSample/dao/UserDao.java
@@ -8,13 +8,11 @@ package org.dhara.portal.web.springHibernateSample.dao;
  * To change this template use File | Settings | File Templates.
  */
 
-import org.dhara.portal.web.springHibernateSample.entity.Customer;
-
-import java.util.List;
+import org.dhara.portal.web.springHibernateSample.entity.User;
 
 public interface UserDao {
 
-    public void saveOrUpdateCustomer(Customer customer);
-    public List<Customer> fetchALLCustomers();
+    public User findById(Long id);
+    public User persistOrMerge(User user);
 
 }
\ No newline at end of file
diff --git a/src/main/java/org/dhara/portal/web/springHibernateSample/entity/Customer.java b/src/main/java/org/dhara/portal/web/springHibernateSample/entity/Customer.java
deleted file mode 100644
index 8e3311a..0000000
--- a/src/main/java/org/dhara/portal/web/springHibernateSample/entity/Customer.java
+++ /dev/null
@@ -1,47 +0,0 @@
-package org.dhara.portal.web.springHibernateSample.entity;
-
-/**
- * Created with IntelliJ IDEA.
- * User: harsha
- * Date: 7/9/13
- * Time: 1:00 PM
- * To change this template use File | Settings | File Templates.
- */
-public class Customer {
-    private long id;
-    private String name;
-    private String address;
-    private String item;
-
-    public long getId() {
-        return id;
-    }
-
-    public void setId(long id) {
-        this.id = id;
-    }
-
-    public String getName() {
-        return name;
-    }
-
-    public void setName(String name) {
-        this.name = name;
-    }
-
-    public String getAddress() {
-        return address;
-    }
-
-    public void setAddress(String address) {
-        this.address = address;
-    }
-
-    public String getItem() {
-        return item;
-    }
-
-    public void setItem(String item) {
-        this.item = item;
-    }
-}
\ No newline at end of file
diff --git a/src/main/java/org/dhara/portal/web/springHibernateSample/entity/User.java b/src/main/java/org/dhara/portal/web/springHibernateSample/entity/User.java
new file mode 100644
index 0000000..ee9430b
--- /dev/null
+++ b/src/main/java/org/dhara/portal/web/springHibernateSample/entity/User.java
@@ -0,0 +1,51 @@
+package org.dhara.portal.web.springHibernateSample.entity;
+
+import javax.persistence.Column;
+import javax.persistence.GeneratedValue;
+import javax.persistence.Id;
+
+/**
+ * Created with IntelliJ IDEA.
+ * User: harsha
+ * Date: 7/9/13
+ * Time: 1:00 PM
+ * To change this template use File | Settings | File Templates.
+ */
+public class User {
+
+    private Long id;
+    private String name;
+    private Integer age;
+
+    public User() {
+    }
+
+    @Id
+    @GeneratedValue
+    public Long getId() {
+        return this.id;
+    }
+
+    private void setId(Long id) {
+        this.id = id;
+    }
+
+    @Column
+    public String getName() {
+        return this.name;
+    }
+
+    public void setName(String name) {
+        this.name = name;
+    }
+
+    @Column
+    public Integer getAge() {
+        return age;
+    }
+
+    public void setAge(Integer age) {
+        this.age = age;
+    }
+
+}
\ No newline at end of file
diff --git a/src/main/java/org/dhara/portal/web/springHibernateSample/service/UserService.java b/src/main/java/org/dhara/portal/web/springHibernateSample/service/UserService.java
index dd5d474..d73cb92 100644
--- a/src/main/java/org/dhara/portal/web/springHibernateSample/service/UserService.java
+++ b/src/main/java/org/dhara/portal/web/springHibernateSample/service/UserService.java
@@ -1,8 +1,6 @@
 package org.dhara.portal.web.springHibernateSample.service;
 
-import org.dhara.portal.web.springHibernateSample.entity.Customer;
-
-import java.util.List;
+import org.dhara.portal.web.springHibernateSample.entity.User;
 
 /**
  * Created with IntelliJ IDEA.
@@ -12,6 +10,6 @@ import java.util.List;
  * To change this template use File | Settings | File Templates.
  */
 public interface UserService {
-    public void saveOrUpdateCustomer(Customer customer);
-    public List<Customer> fetchALLCustomers();
+    public User retrieveUser(Long id);
+    public User createUser(User user);
 }
diff --git a/src/main/java/org/dhara/portal/web/springHibernateSample/service/UserServiceImpl.java b/src/main/java/org/dhara/portal/web/springHibernateSample/service/UserServiceImpl.java
index 1bf86de..19af197 100644
--- a/src/main/java/org/dhara/portal/web/springHibernateSample/service/UserServiceImpl.java
+++ b/src/main/java/org/dhara/portal/web/springHibernateSample/service/UserServiceImpl.java
@@ -1,14 +1,10 @@
 package org.dhara.portal.web.springHibernateSample.service;
 
 import org.dhara.portal.web.springHibernateSample.dao.UserDao;
-import org.dhara.portal.web.springHibernateSample.entity.Customer;
-import org.hibernate.Criteria;
-import org.hibernate.SessionFactory;
+import org.dhara.portal.web.springHibernateSample.entity.User;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.transaction.annotation.Transactional;
 
-import java.util.List;
-
 /**
  * Created with IntelliJ IDEA.
  * User: harsha
@@ -16,23 +12,19 @@ import java.util.List;
  * Time: 1:06 PM
  * To change this template use File | Settings | File Templates.
  */
-public class UserServiceImpl implements UserService {
+public class UserServiceImpl {
 
+    @Autowired(required=true)
     private UserDao userDao;
 
-    public void saveOrUpdateCustomer(Customer customer) {
-        userDao.saveOrUpdateCustomer(customer);
-    }
-
-    public List<Customer> fetchALLCustomers() {
-        return userDao.fetchALLCustomers();
+    @Transactional
+    public User createUser(User user) {
+        return this.userDao.persistOrMerge(user);
     }
 
-    public UserDao getUserDao() {
-        return userDao;
+    @Transactional(readOnly=true)
+    public User retrieveUser(Long id) {
+        return this.userDao.findById(id);
     }
 
-    public void setUserDao(UserDao userDao) {
-        this.userDao = userDao;
-    }
 }
diff --git a/src/main/resources/applicationContext.xml b/src/main/resources/applicationContext.xml
index f4aede7..e69de29 100644
--- a/src/main/resources/applicationContext.xml
+++ b/src/main/resources/applicationContext.xml
@@ -1,52 +0,0 @@
-<?xml version="1.0" encoding="UTF-8"?>
-<beans xmlns="http://www.springframework.org/schema/beans"
-       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
-       xmlns:mvc="http://www.springframework.org/schema/mvc"
-       xmlns:tx="http://www.springframework.org/schema/tx"
-       xmlns:context="http://www.springframework.org/schema/context"
-       xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.1.xsd
-                    http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.1.xsd
-                    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
-                    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd">
-
-    <bean id="dataSourceBean" class="org.apache.commons.dbcp.BasicDataSource" >
-        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
-        <property name="url" value="jdbc:mysql://localhost:3306/dhara"/>
-        <property name="username" value="root"/>
-        <property name="password" value="root"/>
-    </bean>
-
-    <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
-        <property name="dataSource" ref="dataSourceBean"/>
-        <property name="mappingResources">
-            <list>
-                <value>customer.hbm.xml</value>
-            </list>
-        </property>
-
-        <property name="hibernateProperties">
-            <value>hibernate.dialect=org.hibernate.dialect.MySQLDialect
-                hibernate.hbm2ddl.auto=update
-                hibernate.show_sql=true
-            </value>
-        </property>
-    </bean>
-
-    <tx:annotation-driven />
-    <bean id = "transactionManager" class = "org.springframework.orm.hibernate4.HibernateTransactionManager">
-        <property name = "sessionFactory" ref = "sessionFactory" />
-    </bean>
-
-    <bean id="userDao" class="org.dhara.portal.web.springHibernateSample.dao.HibernateUserDao">
-        <property name="sessionFactory">
-            <ref bean="sessionFactory"/>
-        </property>
-    </bean>
-
-    <bean id="userService" class="org.dhara.portal.web.springHibernateSample.service.UserServiceImpl">
-        <property name="userDao">
-            <ref bean="userDao"/>
-        </property>
-    </bean>
-
-</beans>
\ No newline at end of file
diff --git a/src/main/resources/customer.hbm.xml b/src/main/resources/customer.hbm.xml
deleted file mode 100644
index 708b0d3..0000000
--- a/src/main/resources/customer.hbm.xml
+++ /dev/null
@@ -1,18 +0,0 @@
-<?xml version="1.0"?>
-<!DOCTYPE hibernate-mapping PUBLIC
-        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
-        "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
-<hibernate-mapping>
-    <class name="org.dhara.portal.web.springHibernateSample.entity.Customer" table="customer">
-        <id name="id" column="id">
-            <generator class="native">
-            </generator>
-        </id>
-        <property name="name" column="name" type="string"/>
-        <property name="address" column="address" type="string"/>
-        <property name="item" column="item" type="string"/>
-    </class>
-</hibernate-mapping>
-
-
-
diff --git a/src/main/resources/hibernate.cfg.xml b/src/main/resources/hibernate.cfg.xml
new file mode 100644
index 0000000..06e3ae5
--- /dev/null
+++ b/src/main/resources/hibernate.cfg.xml
@@ -0,0 +1,38 @@
+<?xml version='1.0' encoding='utf-8'?>
+<!DOCTYPE hibernate-configuration PUBLIC
+        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
+        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
+
+<hibernate-configuration>
+    <session-factory>
+        <!-- Database connection settings
+        <property name="hibernate.connection.driver_class">org.h2.Driver</property>
+        <property name="hibernate.connection.url">jdbc:h2:./db/repository</property>
+        <property name="hibernate.connection.username">sa</property>
+        <property name="hibernate.connection.password"></property>
+        <property name="hibernate.default_schema">PUBLIC</property>
+        <property name="hibernate.dialect">org.hibernate.dialect.H2Dialect</property>
+        <property name="hibernate.show_sql">true</property>
+        <property name="hibernate.hbm2ddl.auto">update</property>
+
+         JDBC connection pool (use the built-in)
+        <property name="connection.pool_size">1</property>
+
+         SQL dialect
+        <property name="dialect">org.hibernate.dialect.H2Dialect</property>
+
+         Enable Hibernate's automatic session context management
+        <property name="current_session_context_class">thread</property>
+
+         Disable the second-level cache
+        <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>
+
+         Echo all executed SQL to stdout
+        <property name="show_sql">false</property>
+
+        <property name="hbm2ddl.auto">validate</property>-->
+
+        <mapping class="org.dhara.portal.web.springHibernateSample.entity.User" />
+
+    </session-factory>
+</hibernate-configuration>
\ No newline at end of file
diff --git a/src/main/webapp/WEB-INF/jdbc.properties b/src/main/webapp/WEB-INF/jdbc.properties
new file mode 100644
index 0000000..bb8cfe6
--- /dev/null
+++ b/src/main/webapp/WEB-INF/jdbc.properties
@@ -0,0 +1,5 @@
+jdbc.driverClassName= org.h2.Driver
+jdbc.dialect=org.hibernate.dialect.H2Dialect
+jdbc.databaseurl=jdbc:h2:./db/repository
+jdbc.username=sa
+jdbc.password=
\ No newline at end of file
diff --git a/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml b/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml
index 7dd4be1..7c43dd1 100644
--- a/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml
+++ b/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml
@@ -5,6 +5,7 @@
     http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
     ">
 
+
     <!-- the application context definition for the springapp DispatcherServlet -->
 
     <bean name="/helloworld.html" class="org.dhara.portal.web.controllers.HellowWorldController"/>
@@ -20,4 +21,30 @@
             <value>.jsp</value>
         </property>
     </bean>
+
+    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
+        <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
+        <property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
+        <property name="username" value="sa"/>
+        <property name="password" value=""/>
+    </bean>
+
+    <bean id="mysessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
+        <property name="dataSource">
+            <ref bean="dataSource"/>
+        </property>
+        <property name="configLocation">
+            <value>
+                classpath:hibernate.cfg.xml
+            </value>
+        </property>
+        <property name="hibernateProperties">
+            <props>
+                <prop key="hibernate.dialect">org.hibernate.dialect.H2Dialect</prop>
+                <prop key="hibernate.hbm2ddl.auto">update</prop>
+                <prop key="hibernate.show_sql">true</prop>
+            </props>
+        </property>
+    </bean>
+
 </beans>
\ No newline at end of file
diff --git a/src/main/webapp/WEB-INF/web.xml b/src/main/webapp/WEB-INF/web.xml
index 19b2501..ac1f35c 100644
--- a/src/main/webapp/WEB-INF/web.xml
+++ b/src/main/webapp/WEB-INF/web.xml
@@ -37,7 +37,4 @@
         <servlet-name>mvc-dispatcher</servlet-name>
         <url-pattern>*.html</url-pattern>
     </servlet-mapping>
-    <listener>
-        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
-    </listener>
 </web-app>

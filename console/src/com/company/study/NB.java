package com.company.study;

import java.util.List;
import java.util.Random;

public class NB {
    public static void main(String[] args) {
        get();
    }
    private static final Random random = new Random();
    private static final List<String> urls = List.of(
            // Java core
            "https://jsehelper.blogspot.com/2016/01/java-core-1.html",
            "https://jsehelper.blogspot.com/2016/01/java-core-2.html",
            "https://jsehelper.blogspot.com/2016/01/java-core-3.html",
            "https://jsehelper.blogspot.com/2016/12/java-core-4.html",
            // oop
            "https://jsehelper.blogspot.com/2016/01/blog-post_9.html",
            // aop
            "AOP\n \n \n Aspect — модуль или класс, реализующий сквозную функциональность. Аспект изменяет поведение остального кода, применяя совет в точках соединения, определённых некоторым срезом.\n \n Advice — средство оформления кода, которое должно быть вызвано из точки соединения. Совет может быть выполнен до, после или вместо точки соединения.\n \n JoinPoint — точка в выполняемой программе, где следует применить совет. Многие реализации АОП позволяют использовать вызовы методов и обращения к полям объекта в качестве точек соединения.\n \n Pointcut — набор точек соединения. Срез определяет, подходит ли данная точка соединения к данному совету. Самые удобные реализации АОП используют для определения срезов синтаксис основного языка (например, в AspectJ применяются Java-сигнатуры) и допускают их повторное использование с помощью переименования и комбинирования.\n \n Introduction — изменение структуры класса и/или изменение иерархии наследования для добавления функциональности аспекта в инородный код. Обычно реализуется с помощью некоторого метаобъектного протокола (англ. metaobject protocol, MOP).\n",
            // spring
            "https://jsehelper.blogspot.com/2016/02/spring-framework-1.html",
            "https://jsehelper.blogspot.com/2016/03/spring-framework-2.html",
            "https://jsehelper.blogspot.com/2016/03/spring-framework-3.html",
            // java 8
            "https://jsehelper.blogspot.com/2016/05/java-8-1.html",
            "https://jsehelper.blogspot.com/2016/05/java-8-2.html",
            // functional interface
            "https://metanit.com/java/tutorial/9.3.php",
            "write custom @FunctionalInterface",
            // serialization
            "https://jsehelper.blogspot.com/2016/01/blog-post_12.html",
            // io
            "https://jsehelper.blogspot.com/2016/02/java-1.html",
            "https://jsehelper.blogspot.com/2016/02/java-2.html",
            // collection framework
            "https://jsehelper.blogspot.com/2016/01/java-collections-framework-1.html",
            "https://jsehelper.blogspot.com/2016/01/java-collections-framework-2.html",
            "https://jsehelper.blogspot.com/2016/01/java-collections-framework-3.html",
            "https://www.youtube.com/watch?v=rVr1y32fDI0&ab_channel=OnlineUniver",  //hash table
            "https://www.youtube.com/watch?v=ujRnhGc1GNw&ab_channel=OnlineUniver",  //red black tree
            "https://www.youtube.com/watch?v=-gKLTH0KTF4&ab_channel=%D0%91%D1%83%D0%B4%D0%BD%D0%B8%D0%BA%D0%BE%D0%B2%D0%90%D0%BB%D0%B5%D0%BA%D1%81%D0%B0%D0%BD%D0%B4%D1%80",  //red black tree
            // Multithreading
            "https://jsehelper.blogspot.com/2016/01/multithreading-1.html",
            "https://jsehelper.blogspot.com/2016/01/multithreading-2.html",
            // jdbc
            "https://jsehelper.blogspot.com/search/label/JDBC",
            "https://i.pinimg.com/736x/ff/38/1b/ff381b03cabf99c87f0cb97593315340.jpg",
            //Hibernate
            "https://jsehelper.blogspot.com/2016/01/object-relational-mapping-orm-hibernate.html",
            "https://jsehelper.blogspot.com/2016/03/object-relational-mapping-orm-hibernate.html",
            "https://i.pinimg.com/736x/ff/38/1b/ff381b03cabf99c87f0cb97593315340.jpg",
            // db
            "https://jsehelper.blogspot.com/2016/01/blog-post_13.html",
            //sql
            "https://jsehelper.blogspot.com/2016/01/sql-1.html",
            "https://jsehelper.blogspot.com/2016/01/sql-2.html",
            //junit
            "https://jsehelper.blogspot.com/2016/01/junit.html",
            //maven
            "https://jsehelper.blogspot.com/2016/05/maven-1.html",
            "https://jsehelper.blogspot.com/2016/05/maven-2.html",
            //design patterns
            "https://jsehelper.blogspot.com/2016/01/design-patterns.html", //!!!!!!!!!!!!!!!!!!!!!!
            "SOLID\n \n Главная цель этих принципов — повысить гибкость вашей архитектуры, уменьшить связанность между её компонентами и облегчить повторное использование кода.\n \n S - Single-responsiblity principle\n     принцип единой обязанности(ответственности).\n     любй объект должен иметь только одну обязанность  и эта обязаность должна быть полностью\n     реализована в классе объекта\n O - Open-closed principle\n     Принцип открытости закрытости.\n     Классы должны быть открыты для расширения и закрыты для изменения\n     https://netsh.pp.ua/2020/03/principy-solid-v-oop-ocp-chast-2-iz-5/\n     \n L - Liskov substitution principle.\n     Принцип подстановки Лисков.\n     Поведение наследуемых классов не должно противоречить поведению заданному базовым классом.\n     Объекты в программе могут быть заменены их наследниками без изменения свойств программы.\n I - Interface segregation principle.\n     Принцип разделения интерфейса.\n     Много специализированных интерфейсов лучше чем один универсальный.\n D - Dependency Inversion Principle.\n     Принцип инверсии зависимостей\n     Зависимости должны строится относительно абстракций(интерфейсов) а не деталей(классов).\n \n \n Принцип единственной ответственности (Single responsibility)\n «На каждый объект должна быть возложена одна единственная обязанность»\n Для этого проверяем, сколько у нас есть причин для изменения класса — если больше одной, то следует разбить данный класс.\n \n Принцип открытости/закрытости (Open-closed)\n «Программные сущности должны быть открыты для расширения, но закрыты для модификации»\n Для этого представляем наш класс как «чёрный ящик» и смотрим, можем ли в таком случае изменить его поведение.\n \n Принцип подстановки Барбары Лисков (Liskov substitution)\n «Объекты в программе могут быть заменены их наследниками без изменения свойств программы»\n Для этого проверяем, не усилили ли мы предусловия и не ослабили ли постусловия. Если это произошло — то принцип не соблюдается\n \n Принцип разделения интерфейса (Interface segregation)\n «Много специализированных интерфейсов лучше, чем один универсальный»\n Проверяем, насколько много интерфейс содержит методов и насколько разные функции накладываются на эти методы, и если необходимо — разбиваем интерфейсы.\n \n Принцип инверсии зависимостей (Dependency Invertion)\n «Зависимости должны строится относительно абстракций, а не деталей»\n Проверяем, зависят ли классы от каких-то других классов(непосредственно инстанцируют объекты других классов и т.д) и если эта зависимость имеет место, заменяем на зависимость от абстракции.\n",
            //maven
            "https://jsehelper.blogspot.com/2016/05/maven-1.html",
            "https://jsehelper.blogspot.com/2016/05/maven-2.html",
            //gRPC -
            "https://www.youtube.com/watch?v=bfdF4AJELDc&ab_channel=ListenIT",
            "gRPC \n \n Унарный RPC (Unary RPC) — клиент отправляет один запрос на сервер и получает один ответ обратно, как при обычном вызове функции. \n Серверные потоковые RPC (Server streaming RPC), когда клиент отправляет запрос на сервер и получает поток для чтения последовательности сообщений обратно. Клиент читает из возвращенного потока, пока не кончатся сообщения. gRPC гарантирует упорядочение сообщений в рамках отдельного вызова RPC. \n Клиентские потоковые RPC (Client streaming RPC), в которых клиент записывает последовательность сообщений и отправляет их на сервер, снова используя предоставленный поток. После того, как клиент закончил писать сообщения, он ждет, пока сервер прочитает их и вернет свой ответ. Опять же, gRPC гарантирует упорядочение сообщений в рамках отдельного вызова RPC. \n RPC с двунаправленной потоковой передачей (Bidirectional streaming RPC), где обе стороны отправляют последовательность сообщений, используя поток чтения-записи. Два потока работают независимо, поэтому клиенты и серверы могут читать и писать в любом порядке: например, сервер может дождаться получения всех клиентских сообщений, прежде чем записывать свои ответы, или он может поочередно читать сообщение, а затем писать сообщение, или какая-то другая комбинация чтения и записи. Порядок сообщений в каждом потоке сохраняется. \n ",
            // socket
            "WetSocket\n\n протокол связи поверх TCP-соединения, предназначенный для обмена сообщениями между браузером и веб-сервером, используя постоянное соединение. НЕ ПРЕРЫВАЕ СОЕДИНЕНИЯ",
            //gRPC и Websocket
            "https://devby.io/blogs/godel-technologies-europe/articles/skaz-o-tom-kak-razbiralsya-v-grpc-i-websocket"
    );

    public static void get(){
        System.out.println(urls.get(random.nextInt(urls.size())));
    }
}

//              annotation

//            Singleton Pattern: Creating beans with default scope.
//            Factory Pattern: Bean Factory classes
//            Prototype Pattern: Bean scopes /// реализовывает клонирование
//            Adapter Pattern: Spring Web and Spring MVC /// Адаптер выступает прослойкой между двумя объектами, превращая вызовы одного в вызовы понятные другому.
//            Proxy Pattern: Spring Aspect Oriented Programming support /// Заместитель имеет тот же интерфейс, что и реальный объект, поэтому для клиента нет разницы — работать через заместителя или напрямую.
//            Template Method Pattern: JdbcTemplate, HibernateTemplate etc
//            Front Controller: Spring MVC DispatcherServlet
//            Data Access Object: Spring DAO support /// классы которые имплементируют работу с объектор
//            Dependency Injection and Aspect Oriented Programming
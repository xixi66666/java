package sqlTools;

public class test {
    public static void main(String[] args) {
        AuthorTools author_tools = new AuthorTools();
        BookTools book_tools = new BookTools();
        BorrowTools borrowTools = new BorrowTools();
        PublisherTools publisherTools = new PublisherTools();
        ReaderTools readerTools = new ReaderTools();
        /*插入操作测试
        Author author = new Author();
        author.setName("毛姆");
        author_tools.AddAuthor(author);

        List<Author> list = new ArrayList<>();
        list = author_tools.AuthorData();
        for(Author a: list){
            System.out.print(a.getName() + "    ");
            System.out.println(a.getId());
        }

        查找测试
        List<Book> list = new ArrayList<>();
        Book book = new Book();
        list = book_tools.GetBookData("周易");

        for(Book b:list){
            System.out.print(b.getBookId() +"\t");
            System.out.print(b.getAuthor() + "\t");
            System.out.print(b.getPrice() + "\t");
            System.out.println(b.getBookName());
        }

         插入测试

        Book book = new Book("图解http","014",30,"教材","上野宣","人民邮电出版社");
        //注意创建book对象时候的属性字段的插入顺序
        book_tools.AddBook(book);
        List<Book> list = new ArrayList<>();
        list = book_tools.GetBookData();
        for(Book b:list){
            System.out.print(b.getBookId() +"\t");
            System.out.print(b.getAuthor() + "\t");
            System.out.print(b.getPrice() + "\t");
            System.out.println(b.getBookName());
        }



        List<Book> list = new ArrayList<>();
        list = borrowTools.BookData("001");
        for(Book b:list){
            System.out.print(b.getBookId() +"\t");
            System.out.print(b.getAuthor() + "\t");
            System.out.print(b.getPrice() + "\t");
            System.out.println(b.getType() + "\t");
            System.out.println(b.getBookName());
        }

         测试出版社查找
        Publisher publisher = new Publisher();
        publisher = publisherTools.PublisherData("人民出版社");
        System.out.println(publisher.getAddress());
        System.out.println(publisher.getName());


        List<Publisher> list = new ArrayList<>();
        list = publisherTools.AllPublisherData();
        for(Publisher p :list){
            System.out.println(p.getName());
            System.out.println(p.getAddress());
        }


        测试出版社插入

        Publisher publisher = new Publisher();
        publisher.setName("西北大学出版社");
        publisher.setAddress("西安");
        publisherTools.AddPublisher(publisher);

        测试reader

        List<Reader> list = new ArrayList<>();
        list = readerTools.ReaderDataByName("初灵");
        for(Reader r:list){
            System.out.println(r.getSex());
            System.out.println(r.getPassword());
            System.out.println(r.getReaderId());
            System.out.println(r.getReaderName());
            System.out.println(r.getType());
        }
        测试reader查找
        List<Reader> list = new ArrayList<>();
        list = readerTools.AllReaderData();
        for(Reader r:list){
            System.out.println(r.getSex());
            System.out.println(r.getPassword());
            System.out.println(r.getReaderId());
            System.out.println(r.getReaderName());
            System.out.println(r.getType());
        }
        测试reader添加

        Reader reader = new Reader();
        reader.setReaderId("011");
        reader.setReaderName("ycx");
        reader.setType("帅气男子");
        reader.setSex("男");
        reader.setPassword("2000");
        readerTools.AddReader(reader);


        测试reader删除
        readerTools.DeleteReaderData("011");

         */

    }

}

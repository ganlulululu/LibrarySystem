package library;

public class LibraryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1=new Book("1","7302030091","数据库教程");
		Book book2=new Book("2","7302030092","计算机组成原理");
		Book book3=new Book("3","7302030093","Java程序设计");
		Book book4=new Book("4","7302030094","微观经济学");
		Book book5=new Book("5","7302030095","探索宇宙奥秘");
		Book book6=new Book("6","7302030096","影视文学");
		
		Member member1=new Member("1","people1");
		Member member2=new Member("2","people2");
		
		System.out.println("----------menber1借阅book2-------------");
		member1.loanBook(book2);
		System.out.println("----------menber2借阅book2---------------");
		member2.loanBook(book2);
		System.out.println("------------menber2借阅其他书---------------");
		member2.loanBook(book3);
		member2.loanBook(book4);
		member2.loanBook(book5);
		
		member2.loanBook(book1);
		member2.returnBook(book4);
		member2.loanBook(book6);
		
		
	}

}

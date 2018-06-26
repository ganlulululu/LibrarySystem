package library;
import java.util.ArrayList;
import java.util.List;

public class Member {
	private String id;
	private String name;
	private List<Loan> loans = new ArrayList<>(3);
	
	public Member(String id,String name){
		this.id=id;
		this.name=name;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
	public void returnBook(Book book){
		Loan loan=findCurrentLoanFor(book);
		if (loan != null){
			loan.markAsReturned();
			System.out.println("成功归还：《"+book.getTitle()+"》！");
			book.setLoanTo(null);
		}
	}
	
	
	public boolean canLoanBook(Book book){
		
		if(book.getLoanTo()!=null){
			System.out.println("《"+book.getTitle()+"》此书已借出。");
			return false;
		}
		
		HasReachMaxSpecification has=new HasReachMaxSpecification();
		if(!has.IsSatisfiedBy(this)){
			System.out.println("已借3本书，达到了借书上限！");
			return false;
		}
		
		LoanOnlyOneSpecification only=new LoanOnlyOneSpecification(book);
		return only.IsSatisfiedBy(this);
		}
	
	public Loan loanBook(Book book){
		if(!canLoanBook(book)){
//			System.out.println("无法被借出");
			return null;
		}
		Loan loan=LoanFactory.CreateLoan(book, this);
		loans.add(loan);
		return loan;
		}
	
	public Loan findCurrentLoanFor(Book book){
		Member record=book.getLoanTo();
		if(record==null||!record.getId().equals(this.getId())){
			return null;
		}
		for(Loan loan:loans){
			if(loan.getBook().getId().equals(book.getId())&&loan.hasNotBeenReturned()){
//				System.out.println(getName()+"存在BookId为"+book.getId()+"的《"+book.getTitle()+"》这本书");
				return loan;
			}
		}
//		System.out.println(getName()+"没有借过"+"《"+book.getTitle()+"》");
		return null;
		}
	

}

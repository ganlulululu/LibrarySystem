package library;
import library.Book;

public class LoanOnlyOneSpecification implements ISpecification<Member> {
	private Book wantbook;
	public LoanOnlyOneSpecification(Book wantbook){
		this.wantbook=wantbook;
	}
	
	
	@Override
	public boolean IsSatisfiedBy(Member member){
		boolean res=member.getLoans()
	            .stream()
	            .noneMatch(loan -> loan.hasNotBeenReturned() && loan.getBook().getIsbn().equals(wantbook.getIsbn()));
		if(!res){
			System.out.println(member.getName()+"还未归还"+"《"+wantbook.getTitle()+"》，无法再借");
		}
		return res;
	}

	public Book getWantbook() {
		return wantbook;
	}

	public void setWantbook(Book wantbook) {
		this.wantbook = wantbook;
	}

}

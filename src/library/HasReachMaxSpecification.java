package library;

public class HasReachMaxSpecification implements ISpecification<Member>{

	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		boolean res=member.getLoans().stream().filter(Loan::hasNotBeenReturned).count()<3;
		return res;
	}

}

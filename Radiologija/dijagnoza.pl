contains(S,[]).
contains(S,[H|T]) :- member(H,S), contains(S,T).
	
dijagnoza(X, D) :- (anamneza(X, A), simptomi(D, LS), contains(LS,A)), (pregled(X, P), dijagnosticka_procedura(D, DPL), contains(DPL,P)).


dalja_ispitivanja_zakljucak(X,D,Z):-dijagnoza(X,D),dalja_ispitivanja(D,Z).
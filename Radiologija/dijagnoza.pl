contains(S,[]).
contains(S,[H|T]) :- member(H,S), contains(S,T).


dijagnoza(X, D) :- (anamneza(X, A), simptomi(D, LS), contains(LS,A)), (pregled(X, P), dijagnosticka_procedura(D, DPL), contains(DPL,P)).
zensko(olga).
zensko(jovana).
zensko(rada).

musko(pera).
musko(mika).

pacijent(X):- zensko(X).
pacijent(X):- musko(X).


godine(olga,1).
godine(rada,25).

beba(X):-godine(X,Y), Y=<2.
dete(X):- godine(X,Y), Y>2, Y=<12.
adolescent(X):- godine(X,Y), Y>=13, Y=<19.
mladja_osoba(X):- godine(X,Y), Y>=20, Y<40.
starija_osoba(X):- godine(X,Y), Y>=40, Y<60.
stara_osoba(X):- godine(X,Y), Y>=60.



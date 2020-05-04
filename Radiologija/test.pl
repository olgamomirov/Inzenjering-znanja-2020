dijagnoza(Ime, Dijagnoza) :- 

anamneza(Ime, A_lista),
dijagnosticka_procedura(Ime, DP_lista),

(
   member(svrab, A_lista); 
   member(modra_noga, A_lista); 
   member(otecena_noga, A_lista); 
   member(osecaj_zatezanja, A_lista)
),

(
   member(nekompresibilna_vena, DP_lista),
   member(protok_krvi_ne_registrovan, DP_lista),
   member(prosirene_spoljasnje_vene, DP_lista)
),

Dijagnoza=duboka_venska_tromboza,!.


% *************************SLEDECA*************************

dijagnoza(Ime,Dijagnoza):- 
anamneza(Ime,A_lista),
dijagnosticka_procedura(Ime,DP_lista),
member(stitasta_zlezda_deformisane_konture,DP_lista),

(
(
   member(genetski_faktor,A_lista);
   member(povisena_temperatura,A_lista);
   member(bol_u_vratu_u_regiji_stitaste_zlezde,A_lista);
   member(preznojavanje,A_lista);
   member(drhtanje,A_lista);
   member(opadanje_kose,A_lista);
   member(povisen_krvni_pritisak,A_lista);
   member(dekoncentracija,A_lista)
),
(
   member(stitasta_zlezda_uvecana,DP_lista),
   member(signal_krvnih_sudova_pojacan,DP_lista)
),
   Dijagnoza=hasimoto_tireoditis_hiper_faza,!;

(
   member(genetski_faktor,A_lista);
   member(zamor,A_lista);
   member(pospanost,A_lista);
   member(podbulost,A_lista);
   member(pojacano_gojenje,A_lista);
   member(opadanje_kose,A_lista);
   member(nemogucnost_skidanja_kilograma,A_lista);
   member(izostanak_ciklusa,A_lista)
),

   % not(member(preznojavanje,A_lista)), 
   % PITANJE: DA LI JEDAN SIMPTOM DA NAM RUSI SVE

(
   member(stitasta_zlezda_smanjena,DP_lista),
   member(signal_krvnih_sudova_smanjen,DP_lista)
),

Dijagnoza=hasimoto_tireoditis_hipo_faza,!
).

% *************************SLEDECA*************************

dijagnoza(Ime, Dijagnoza) :- 

anamneza(Ime, A_lista),
dijagnosticka_procedura(Ime, DP_lista),


(
(
   member(mucnina, A_lista); 
   member(gadjenje, A_lista); 
   member(nadimanje, A_lista); 
   member(neredovna_ishrana, A_lista);
   member(povracanje, A_lista);
   member(gojaznost, A_lista);
   member(bol_ispod_desnog_rebarnog_luka, A_lista)  
),
(
   member(bela_ovalna_struktura_unutar_zucne_kese, DP_lista),
   not(member(zid_zucne_kese_raslojen_i_zadebljan, DP_lista))
),

Dijagnoza=holelitijaza,!;

(
   member(mucnina, A_lista); 
   member(gadjenje, A_lista); 
   member(nadimanje, A_lista); 
   member(neredovna_ishrana, A_lista);
   member(povracanje, A_lista);
   member(gojaznost, A_lista);
   member(bol_ispod_desnog_rebarnog_luka, A_lista)  
),
(
   member(bela_ovalna_struktura_unutar_zucne_kese, DP_lista),
   member(zid_zucne_kese_raslojen_i_zadebljan, DP_lista)
),
Dijagnoza=holecistitis,!;

(
   member(mucnina, A_lista); 
   member(gadjenje, A_lista); 
   member(nadimanje, A_lista); 
   member(neredovna_ishrana, A_lista);
   member(povracanje_crnog_sadrzaja_tj_preradjene_krvi, A_lista);
   member(mrsavost, A_lista);
   member(crna_stolica, A_lista)  
),
(
   member(prosiren_zeludac_i_12pal_crevo, DP_lista),
   member(postoje_limfni_cvorovi_u_okolini_12pal_creva, DP_lista),
   member(postoji_slobodna_tecnost_u_okolini_12pal_creva, DP_lista)
  
),
Dijagnoza=cir_na_12palacnom_crevu,!
).         

% *************************SLEDECA*************************


neoredjena_dijagnoza(Ime,cista_benigni):- 

dijagnosticka_procedura(Ime, DP_lista),
(
   member(vidljiva_ovalna_homogena_ostro_ogranicena_zona, DP_lista),
   member(signal_krvnih_sudova_nepostojeci_ili_po_rubu, DP_lista),
   member(iza_cvora_pojacan_ultrazvucni_talas, DP_lista)
).

dijagnoza(Ime,Dijagnoza) :-

anamneza(Ime,A_lista),
dijagnosticka_procedura(Ime, DP_lista),

(
   (
      neoredjena_dijagnoza(Ime, Bitno_za_dijagnozu),

   (      
      member(bolan_cvor_na_dojci, A_lista);
      member(cvor_je_elastican, A_lista)
   ),
   Bitno_za_dijagnozu=cista_benigni,
   
   Dijagnoza=cista,!;

   (
      member(bezbolan_cvor_na_dojci, A_lista);
      member(krv_na_bradavici_dojke, A_lista);
      member(cvor_je_pokretan, A_lista)
   ),
   Bitno_za_dijagnozu=cista_benigni,

   Dijagnoza=benigni_tumor_dojke,!
   );


   (  
      member(bezbolan_cvor_na_dojci, A_lista);
      member(krv_na_bradavici_dojke, A_lista);
      member(genetski_faktor, A_lista);
      member(cvor_je_fiksiran, A_lista);
      member(uvucena_bradavica_na_dojci, A_lista);
      member(jamica_na_dojci_ispod_koje_je_tvrdo, A_lista)    
   ),
   (
      member(vidljiva_zvezdasta_nehomogena_neostro_ogranicena_zona, DP_lista),
      member(signal_krvnih_sudova_u_centru_cvora, DP_lista),
      member(iza_cvora_slabiji_ultrazvucni_talas, DP_lista)
   ),
   Dijagnoza=maligni_tumor_dojke
  
).


dijagnoza(Ime,Dijagnoza) :-

dijagnosticka_procedura(Ime, DP_lista),
dijagnoza(Ime,D),
D=maligni_tumor_dojke,
(
   member(prisutni_patoloski_limfni_cvorovi_u_pazuhu,DP_lista),
   not(member(udaljene_metastaze,DP_lista)),
   Dijagnoza=maligni_tumor_dojke_faza3,!;

   member(udaljene_metastaze,DP_lista),
   Dijagnoza=maligni_tumor_dojke_faza4,!;

   member(cvor_od_10_do_20mm,DP_lista),
   not(member(prisutni_patoloski_limfni_cvorovi_u_pazuhu,DP_lista)),
   not(member(udaljene_metastaze,DP_lista)),
   Dijagnoza=maligni_tumor_dojke_faza1,!;

   member(cvor_veci_od_20mm,DP_lista),
   not(member(prisutni_patoloski_limfni_cvorovi_u_pazuhu,DP_lista)),
   not(member(udaljene_metastaze,DP_lista)),
   Dijagnoza=maligni_tumor_dojke_faza2,!

).
% *************************SLEDECA*************************
anamneza(rada,[svrab,modra_noga]).
dijagnosticka_procedura(rada,[nekompresibilna_vena,protok_krvi_ne_registrovan,prosirene_spoljasnje_vene]).

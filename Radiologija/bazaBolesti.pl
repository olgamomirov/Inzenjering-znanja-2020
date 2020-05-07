% DONJI EKSTREMITETI
simptomi(duboka_venska_tromboza, [otecena_noga, modra_noga, topla_noga, osecaj_zatezanja_na_nozi, noga_svrbi, bol_u_nozi]).
simptomi(embolija, [otecena_noga, hladna_noga, bleda_noga , bol_u_nozi , modra_noga, noga_svrbi]).
simptomi(erizipel, [otecena_noga,modra_noga, topla_noga, povisena_telesna_tempetatura , osecaj_zatezanja_na_nozi, noga_svrbi, bol_u_nozi]).

dijagnosticka_procedura(duboka_venska_tromboza, [nekompresibilna_vena, protok_krvi_kroz_venu_se_ne_registruje, arterijski_protok_se_registruje, prosirene_spoljasnje_vene]).
dijagnosticka_procedura(embolija, [protok_krvi_kroz_venu_se_ne_registruje, arterijski_protok_se_ne_registruje]).
dijagnosticka_procedura(erizipel, [protok_krvi_kroz_venu_se_registruje, arterijski_protok_se_registruje, prosirene_spoljasnje_vene]).

dalja_ispitivanja(duboka_venska_tromboza,vaskularni_hirurg).
dalja_ispitivanja(embolija, vaskularni_hirurg).
dalja_ispitivanja(erizipel, infektolog).


% HASIMOTO TIREODITIS
simptomi(hasimoto_tireoditis_hiper_faza, [genetski_faktor, povisena_telesna_tempetatura, bol_u_vratu_u_regiji_stitaste_zlezde, preznojavanje, drhtanje, opadanje_kose, povisen_krvni_pritisak, dekoncentracija]).
simptomi(hasimoto_tireoditis_hipo_faza, [genetski_faktor, zamor, pospanost, podbulost, pojacano_gojenje, nemogucnost_skidanja_kila, izostanak_ciklusa]).


dijagnosticka_procedura(hasimoto_tireoditis_hiper_faza, [stitasta_zlezda_deformisane_konture, stitasta_zlezda_uvecana, signal_krvnih_sudova_pojacan]).
dijagnosticka_procedura(hasimoto_tireoditis_hipo_faza, [stitasta_zlezda_deformisane_konture, stitasta_zlezda_smanjena, signal_krvnih_sudova_smanjen]).


% KAMEN U ZUCNOJ KESI tj. HOLELITIJAZA, CIR NA 12PALACNOM CREVU tj. ULKUS DUADENUMA
simptomi(kamen_u_zucnoj_kesi___holelitijaza, [mucnina, gadjenje, neredovna_ishrana, povracanje, gojaznost, bol_ispod_desnog_rebarnog_luka]).
simptomi(upala_zucne_kese___holecistitis, [mucnina, gadjenje, neredovna_ishrana, povracanje, gojaznost, bol_ispod_desnog_rebarnog_luka]).
simptomi(cir_na_12palacnom_crevu___ulkus_duadenuma, [mucnina, gadjenje, neredovna_ishrana, povracanje_preradjene_krvi, mrsavost, crna_stolica]).


dijagnosticka_procedura(kamen_u_zucnoj_kesi___holelitijaza, [bela_ovalna_struktura_unutar_zucne_kese]).
dijagnosticka_procedura(upala_zucne_kese___holecistitis, [bela_ovalna_struktura_unutar_zucne_kese, zid_zucne_kese_raslojen_i_zadebljan]).
dijagnosticka_procedura(cir_na_12palacnom_crevu___ulkus_duadenuma, [prosiren_zeludac_i_12pal_crevo, postoje_limfni_cvorovi_u_okolini_12pal_creva, postoji_slobodna_tecnost_u_okolini_12pal_creva]).

% BOLESTI DOJKE  CISTE , BENIGNI / MALIGNI TUMOR
simptomi(cista_na_dojci, [bolan_cvor_na_dojci, cvor_je_elastican]).
simptomi(benigni_tumor_dojke, [bezbolan_cvor_na_dojci, krv_na_bradavici_dojke, cvor_je_pokretan]).
simptomi(maligni_tumor_dojke, [bezbolan_cvor_na_dojci, krv_na_bradavici_dojke,cvor_je_fiksiran, uvucena_bradavica_na_dojci, jamica_na_dojci_ispod_koje_je_tvrdo, genetski_faktor ]).

simptomi(maligni_tumor_dojke_faza1, [bezbolan_cvor_na_dojci, krv_na_bradavici_dojke,cvor_je_fiksiran, uvucena_bradavica_na_dojci, jamica_na_dojci_ispod_koje_je_tvrdo, genetski_faktor ]).
simptomi(maligni_tumor_dojke_faza2, [bezbolan_cvor_na_dojci, krv_na_bradavici_dojke,cvor_je_fiksiran, uvucena_bradavica_na_dojci, jamica_na_dojci_ispod_koje_je_tvrdo, genetski_faktor ]).
simptomi(maligni_tumor_dojke_faza3, [bezbolan_cvor_na_dojci, krv_na_bradavici_dojke,cvor_je_fiksiran, uvucena_bradavica_na_dojci, jamica_na_dojci_ispod_koje_je_tvrdo, genetski_faktor ]).
simptomi(maligni_tumor_dojke_faza4, [bezbolan_cvor_na_dojci, krv_na_bradavici_dojke,cvor_je_fiksiran, uvucena_bradavica_na_dojci, jamica_na_dojci_ispod_koje_je_tvrdo, genetski_faktor ]).


dijagnosticka_procedura(cista_na_dojci, [vidljiva_ovalna_homogena_ostro_ogranicena_zona, signal_krvnih_sudova_nepostojeci_ili_po_rubu, iza_cvora_pojacan_ultrazvucni_talas]).
dijagnosticka_procedura(benigni_tumor_dojke, [vidljiva_ovalna_homogena_ostro_ogranicena_zona, signal_krvnih_sudova_nepostojeci_ili_po_rubu, iza_cvora_pojacan_ultrazvucni_talas]).
dijagnosticka_procedura(maligni_tumor_dojke, [vidljiva_zvezdasta_nehomogena_neostro_ogranicena_zona, signal_krvnih_sudova_u_centru_cvora, iza_cvora_slabiji_ultrazvucni_talas]).

dijagnosticka_procedura(maligni_tumor_dojke_faza1, [vidljiva_zvezdasta_nehomogena_neostro_ogranicena_zona, signal_krvnih_sudova_u_centru_cvora, iza_cvora_slabiji_ultrazvucni_talas, cvor_od_10_do_20mm]).
dijagnosticka_procedura(maligni_tumor_dojke_faza2, [vidljiva_zvezdasta_nehomogena_neostro_ogranicena_zona, signal_krvnih_sudova_u_centru_cvora, iza_cvora_slabiji_ultrazvucni_talas, cvor_veci_od_20mm]).
dijagnosticka_procedura(maligni_tumor_dojke_faza3, [vidljiva_zvezdasta_nehomogena_neostro_ogranicena_zona, signal_krvnih_sudova_u_centru_cvora, iza_cvora_slabiji_ultrazvucni_talas, prisutni_patoloski_limfni_cvorovi_u_pazuhu]).
dijagnosticka_procedura(maligni_tumor_dojke_faza4, [vidljiva_zvezdasta_nehomogena_neostro_ogranicena_zona, signal_krvnih_sudova_u_centru_cvora, iza_cvora_slabiji_ultrazvucni_talas, udaljene_metastaze]).

% BOLESTI BUBREGA tj. MALIGNI / BENIGNI TUMOR,  KAMEN 
simptomi(kamen_u_bubregu, [bolno_mokrenje_krvi, ostar_bol_u_bubreznoj_lozi, povisena_telesna_temperatura]).
simptomi(benigni_tumor_bubrega, [bezbolno_mokrenje_krvi, tup_bol_u_bubreznoj_lozi]).
simptomi(maligni_tumor_bubrega, [bezbolno_mokrenje_krvi, tup_bol_u_bubreznoj_lozi]).

simptomi(maligni_tumor_bubrega_faza1, [bezbolno_mokrenje_krvi, tup_bol_u_bubreznoj_lozi]).
simptomi(maligni_tumor_bubrega_faza2, [bezbolno_mokrenje_krvi, tup_bol_u_bubreznoj_lozi]).
simptomi(maligni_tumor_bubrega_faza3, [bezbolno_mokrenje_krvi, tup_bol_u_bubreznoj_lozi]).
simptomi(maligni_tumor_bubrega_faza4, [bezbolno_mokrenje_krvi, tup_bol_u_bubreznoj_lozi]).


dijagnosticka_procedura(kamen_u_bubregu, [bubreg_je_uvecan, vidljiva_bela_ovalna_struktura_u_sabirnom_sistemu_bubrega]).
dijagnosticka_procedura(benigni_tumor_bubrega, [bubreg_je_uvecan, bubreg_deformisane_konture, na_bubregu_primetne_izrasline_u_vidu_cvorova, primetne_izrasline_u_vidu_cvorova_na_sabirnom_sistemu, cvorovi_su_ekspanzivni_i_heterogeni, krvni_sudovi_na_rubu_cvora, nema_kalcifikacija_u_cvoru, nema_masne_komponente_u_cvoru]).
dijagnosticka_procedura(maligni_tumor_bubrega, [bubreg_je_uvecan, bubreg_deformisane_konture, na_bubregu_primetne_izrasline_u_vidu_cvorova, primetne_izrasline_u_vidu_cvorova_na_sabirnom_sistemu, cvorovi_su_ekspanzivni_i_heterogeni, krvni_sudovi_u_centru_cvora, ima_kalcifikacija_u_cvoru, ima_masne_komponente_u_cvoru]).

dijagnosticka_procedura(maligni_tumor_bubrega_faza1, [bubreg_je_uvecan, bubreg_deformisane_konture, na_bubregu_primetne_izrasline_u_vidu_cvorova, primetne_izrasline_u_vidu_cvorova_na_sabirnom_sistemu,cvorovi_su_ekspanzivni_i_heterogeni, krvni_sudovi_u_centru_cvora, ima_kalcifikacija_u_cvoru, ima_masne_komponente_u_cvoru, cvor_u_bubregu]).
dijagnosticka_procedura(maligni_tumor_bubrega_faza2, [bubreg_je_uvecan, bubreg_deformisane_konture, na_bubregu_primetne_izrasline_u_vidu_cvorova, primetne_izrasline_u_vidu_cvorova_na_sabirnom_sistemu, cvorovi_su_ekspanzivni_i_heterogeni, krvni_sudovi_u_centru_cvora, ima_kalcifikacija_u_cvoru, ima_masne_komponente_u_cvoru, cvor_u_bubregu_i_delom_van_bubrega]).
dijagnosticka_procedura(maligni_tumor_bubrega_faza3, [bubreg_je_uvecan, bubreg_deformisane_konture, na_bubregu_primetne_izrasline_u_vidu_cvorova, primetne_izrasline_u_vidu_cvorova_na_sabirnom_sistemu, cvorovi_su_ekspanzivni_i_heterogeni, krvni_sudovi_u_centru_cvora, ima_kalcifikacija_u_cvoru, ima_masne_komponente_u_cvoru, limfni_cvorovi_u_neposrednoj_okolini]).
dijagnosticka_procedura(maligni_tumor_bubrega_faza4, [bubreg_je_uvecan, bubreg_deformisane_konture, na_bubregu_primetne_izrasline_u_vidu_cvorova, primetne_izrasline_u_vidu_cvorova_na_sabirnom_sistemu, cvorovi_su_ekspanzivni_i_heterogeni, krvni_sudovi_u_centru_cvora, ima_kalcifikacija_u_cvoru, ima_masne_komponente_u_cvoru, udaljene_metastaze]).



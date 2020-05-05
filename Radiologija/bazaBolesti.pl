% DONJI EKSTREMITETI
simptomi(duboka_venska_tromboza, [otecena_noga, modra_noga, topla_noga, osecaj_zatezanja_na_nozi, noga_svrbi, bol_u_nozi]).
simptomi(embolija, [otecena_noga, hladna_noga, bleda_noga , bol_u_nozi , modra_noga, noga_svrbi]).
simptomi(erizipel, [otecena_noga,modra_noga, topla_noga, povisena_telesna_tempetatura , osecaj_zatezanja_na_nozi, noga_svrbi, bol_u_nozi]).

dijagnosticka_procedura(duboka_venska_tromboza, [nekompresibilna_vena, protok_krvi_kroz_venu_se_ne_registruje, arterijski_protok_se_registruje, prosirene_spoljasnje_vene]).
dijagnosticka_procedura(embolija, [protok_krvi_kroz_venu_se_ne_registruje, arterijski_protok_se_ne_registruje]).
dijagnosticka_procedura(erizipel, [protok_krvi_kroz_venu_se_registruje, arterijski_protok_se_registruje, prosirene_spoljasnje_vene]).



% HASIMOTO TIREODITIS
simptomi(hasimoto_tireoditis_hiper_faza, [genetski_faktor, povisena_telesna_tempetatura, bol_u_vratu_u_regiji_stitaste_zlezde, preznojavanje, drhtanje, opadanje_kose, povisen_krvni_pritisak, dekoncentracija]).
simptomi(hasimoto_tireoditis_hipo_faza, [genetski_faktor, zamor, pospanost, podbulost, pojacano_gojenje, nemogucnost_skidanja_kila, izostanak_ciklusa]).


dijagnosticka_procedura(hasimoto_tireoditis_hiper_faza, [stitasta_zlezda_deformisane_konture, stitasta_zlezda_uvecana, signal_krvnih_sudova_pojacan]).
dijagnosticka_procedura(hasimoto_tireoditis_hipo_faza, [stitasta_zlezda_deformisane_konture, stitasta_zlezda_smanjena, signal_krvnih_sudova_smanjen]).

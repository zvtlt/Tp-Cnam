#
verbose=true

bean.id.1=pouchla
pouchla.class=exemple_alcool.Bar
pouchla.property.1=nom
pouchla.property.1.param.1=POUCHLA
pouchla.property.2=lieu
pouchla.property.2.param.1=10 rue Mandar Paris, France

bean.id.2=zurSteipe
zurSteipe.class=exemple_alcool.Bar
zurSteipe.property.1=nom
zurSteipe.property.1.param.1=Zur Steipe
zurSteipe.property.2=lieu
zurSteipe.property.2.param.1=Dietrichstrasse 54 Trier, Allemagne

bean.id.3=clientDuBar
clientDuBar.class=exemple_alcool.ClientDuBar
clientDuBar.property.1=nom
clientDuBar.property.1.param.1=Jim
clientDuBar.property.2=age
clientDuBar.property.2.param.1=20
clientDuBar.property.3=bar
clientDuBar.property.3.param.1=zurSteipe

bean.id.4=aPlusDe18
aPlusDe18.class=exemple_alcool.RegleAlcoolMoinsDe18$APlusDe
aPlusDe18.property.1=age
aPlusDe18.property.1.param.1=18

bean.id.5=aPlusDe21
aPlusDe21.class=exemple_alcool.RegleAlcoolMoinsDe18$APlusDe
aPlusDe21.property.1=age
aPlusDe21.property.1.param.1=21

bean.id.6=aPlusDe16
aPlusDe16.class=exemple_alcool.RegleAlcoolMoinsDe18$APlusDe
aPlusDe16.property.1=age
aPlusDe16.property.1.param.1=16

bean.id.7=aPlusDe14
aPlusDe14.class=exemple_alcool.RegleAlcoolMoinsDe18$APlusDe
aPlusDe14.property.1=age
aPlusDe14.property.1.param.1=14

bean.id.8=enFrance
enFrance.class=exemple_alcool.RegleAlcoolMoinsDe18$EstEn
enFrance.property.1=lieu
enFrance.property.1.param.1=France

bean.id.9=enAllemagne
enAllemagne.class=exemple_alcool.RegleAlcoolMoinsDe18$EstEn
enAllemagne.property.1=lieu
enAllemagne.property.1.param.1=Allemagne

bean.id.10=auxEtatsUnis
auxEtatsUnis.class=exemple_alcool.RegleAlcoolMoinsDe18$EstAux
auxEtatsUnis.property.1=lieu
auxEtatsUnis.property.1.param.1=EtatsUnis

bean.id.11=vinsMousseuxEtBieres
vinsMousseuxEtBieres.class=exemple_alcool.RegleAlcoolMoinsDe18$VinsMousseuxEtBieres
vinsMousseuxEtBieres.property.1=boissons
vinsMousseuxEtBieres.property.1.param.1=erdinger bitburger cremant_de_Luxembourg

bean.id.12=enPresenceDesParents
enPresenceDesParents.class=exemple_alcool.RegleAlcoolMoinsDe18$EstEnPresenceDesParents

bean.id.13=regle_france
regle_france.class=question1.All
regle_france.property.1=specifications
regle_france.property.1.param.1=enFrance aPlusDe18

bean.id.14=regle_etats_unis
regle_etats_unis.class=question1.All
regle_etats_unis.property.1=specifications
regle_etats_unis.property.1.param.1=auxEtatsUnis aPlusDe21

bean.id.15=regle_allemagne_supplementaire2
regle_allemagne_supplementaire2.class=question1.All
regle_allemagne_supplementaire2.property.1=specifications
regle_allemagne_supplementaire2.property.1.param.1=enPresenceDesParents vinsMousseuxEtBieres aPlusDe14

bean.id.16=regle_allemagne_supplementaire3
regle_allemagne_supplementaire3.class=question1.All
regle_allemagne_supplementaire3.property.1=specifications
regle_allemagne_supplementaire3.property.1.param.1=vinsMousseuxEtBieres aPlusDe16

bean.id.17=regle_allemagne_supplementaire
regle_allemagne_supplementaire.class=question1.OneOf
regle_allemagne_supplementaire.property.1=specifications
regle_allemagne_supplementaire.property.1.param.1=aPlusDe18 regle_allemagne_supplementaire2 regle_allemagne_supplementaire3



bean.id.18=regle_allemagne
regle_allemagne.class=question1.All
regle_allemagne.property.1=specifications
regle_allemagne.property.1.param.1=enAllemagne regle_allemagne_supplementaire


bean.id.19=regle
regle.class=question1.OneOf
regle.property.1=specifications
regle.property.1.param.1=regle_france regle_etats_unis regle_allemagne







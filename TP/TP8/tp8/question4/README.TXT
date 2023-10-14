#verbose=true

bean.id.1=requete_create
requete_create.class=question4.Requete
#requete_create.property.1=url
#requete_create.property.1.param.1=GET /create/?nom=temperature&valeur=200
# ou bien à l'aide des mutateurs
requete_create.property.1=nom
requete_create.property.1.param.1=temperature
requete_create.property.2=valeur
requete_create.property.2.param.1=200
requete_create.property.3=commande
requete_create.property.3.param.1=create

bean.id.2=requete_retrieve
requete_retrieve.class=question4.Requete
requete_retrieve.property.1=url
requete_retrieve.property.1.param.1=GET /retrieve/?nom=temperature

bean.id.3=requete_update
requete_update.class=question4.Requete
requete_update.property.1=url
requete_update.property.1.param.1=GET /update/?nom=temperature&valeur=40

bean.id.4=requete_delete
requete_delete.class=question4.Requete
requete_delete.property.1=url
requete_delete.property.1.param.1=GET /delete/?nom=temperature

bean.id.5=log_bean
log_bean.class=question4.Log
log_bean.property.1=next
log_bean.property.1.param.1=create_bean

bean.id.6=create_bean
create_bean.class=question4.Create
create_bean.property.1=next
create_bean.property.1.param.1=retrieve_bean

bean.id.7=retrieve_bean
retrieve_bean.class=question4.Retrieve
retrieve_bean.property.1=next
retrieve_bean.property.1.param.1=update_bean

bean.id.8=update_bean
update_bean.class=question4.Update
update_bean.property.1=next
update_bean.property.1.param.1=delete_bean

bean.id.9=delete_bean
delete_bean.class=question4.Delete
delete_bean.property.1=next
delete_bean.property.1.param.1=null
#delete_bean.property.1.param.1=debug_bean

bean.id.10=debug_bean
debug_bean.class=question4.Debug
debug_bean.property.1=next
debug_bean.property.1.param.1=null
#debug_bean.property.1.param.1=invoker_bean

bean.id.11=invoker_bean
invoker_bean.class=question4.Invoker
invoker_bean.property.1=command
invoker_bean.property.1.param.1=command_bean

bean.id.12=command_bean
command_bean.class=question4.ChainCommand
command_bean.property.1=chain
command_bean.property.1.param.1=log_bean

bean.id.13=requete_debug
requete_debug.class=question4.Requete
requete_debug.property.1=url
requete_debug.property.1.param.1=GET /debug/




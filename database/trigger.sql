create trigger tarea_update 
before update on tarea 
for each row
execute procedure tf();



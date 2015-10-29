function set_opacity(id,opacity){
   var element = $("#"+id);
   element.animate({"opacity":opacity}); // opacity variant de 0 à 1
}
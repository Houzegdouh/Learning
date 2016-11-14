/*créer trois fonction anneau(sous forme de tableau pour faire plusieurs anneaux), tête puis chenille qui va inclure anneau et tête)
*une fois la chenille prête on s'occupera du mouvement, trêve de bavardage au boulot*/

//------------------------------------------------------------------------------
// le type Anneau
//------------------------------------------------------------------------------
/**créer un objet anneau avec trois variable et le returner vu que c'est une fonction, on veut que ce soit un modéle à réutiliser d'ou la logique de l'objet
*pour ça on mettra des this devant chaque variable pour définir son caractère local que ce soit une variable définit et claire, elle aura un effet sur tout le document
*/
/* pour un premier temps l'objet anneau incluera incluera trois variable x, y, r pour abcisse ordonnée et rayon vu que c'est un cercle*/

function Anneau(x, y, r){
  this.x=x;
  this.y=y;
  this.r=r;
}

/*La bonne méthode pour créer les anneaux*/
//Dessiner l'anneau, le parametre sera le graphicContext car on fera appel au 2D canvas
/*anneau sera un objet en prototype c'est à dire reprendre les paramtres des this au dessus et les appliquer à la fonction dessiner qui prend le graphicContext
comme parametre*/
Anneau.prototype.dessiner = function(graphicContext) {
    graphicContext.beginPath(); //on ouvre de nouveau parametre
    graphicContext.arc(this.x, this.y, this.r, 0, Math.PI * 2, true);//on réutilise les this car ils seront appler des parametre de la fonction anneau
    graphicContext.strokeStyle="coral";
    graphicContext.fillStyle= "rgb(5, 117, 0)";
    graphicContext.fill();
    graphicContext.stroke();
  };
/**
*l'anneau est créé c'est bien joli mais à présent il va faloir le mettre qq part sur la page, à nous de choisir ses coordonnées
*magnifique non....logique et simple, la programmation se fait étape par étape chaque problème doit être découper en plusieurs petites tâches
*ça sera un objet comme plus haut une fonction à objet prototype et contructeur .
*/
Anneau.prototype.placerA = function(a){ //a sera l'objet de position
  this.x = a.x;
  this.y = a.y;
};// on a porter la variable this au a qui sera pour la position x abcisse de a et y ordonnée de a au final, a sera un point.


/**-----La tête------
*
*
*
*
*On va construire la tête (l'objet), pour cela on procédera comme précedemment, vu que c'est également un cercle il prendra les
même parametres x, y, r*/

function Tete (x, y, r){
  this.x = x;
  this.y = y;
  this.r = r;
  this.cap = 0; //vu que c'est une tête elle a un cap, au début il est nul vu qu'il n y a pas de mouvement
}
//Methode, Methode, tout est dans la Methode, le même blabla que tout à l'heure.
Tete.prototype.dessiner = function(graphicContext) {
  graphicContext.beginPath();
  graphicContext.arc(this.x, this.y, this.r, 0, Math.PI*2, true);
  graphicContext.strokeStyle="red";
  graphicContext.fillStyle="black";
  graphicContext.stroke();
  graphicContext.fill();//voilà de la même manière nous avons dessiner une jolie tête
};
/*à présent on devra choisir la déviation du cap ou bien plus précisement le déplacement de la tête, ça nous servira à lui
*faire changer de cap lorsque la tête entrera en contact avec la bordur du canvas.*/

Tete.prototype.devierCap = function(deltaCap){
  this.cap += deltaCap;//deltacap ici définit la variation du cap vu que c'est la variable prise en parametre.
};
/**
*après avoir créer la fonction du cap, on devra la tester pour vérifier si elle est au bout du canvas, si c'est le cas on lui
*ordonnera e changer de direction avec la fonction round qui utilise des sin et cos (parametre en radians donc le cap en degrés
*devra être converti en radians)
*/

Tete.prototype.capOK = function(canvas){
  //ici prend en parametre le canvas car c'est la valeur à tester pour voir si on y est toujours ou non
  var x1 = Math.round(this.x + this.r * Math.cos(Math.PI * this.cap / 180));
  var y1 = Math.round(this.y + this.r * Math.sin(Math.PI * this.cap / 180));
  return x1 >= this.r && x1 <= (canvas.width - this.r)
          && y1 >= this.r && y1 <= (canvas.height - this.r);
};
//maintenant que la tête ) changer de cap, on devra lui ordonner d'avancer tout simplement

Tete.prototype.deplacerSelonCap = function(){
  this.x = Math.round(this.x + this.r * Math.cos(Math.PI * this.cap / 180));
  this.y = Math.round(this.y + this.r * Math.sin(Math.PI * this.cap / 180));
};

/** à présent on passe au gros morceau, la chenille*/
//-------La chenille----------//

function chenille (canvas, nbAnneaux, r){
  this.canvas = canvas;
  //à présent on place la tête de la chenille au centre
  var x = Math.round(canvas.width / 2);
  var y = Math.round(canvas.height / 2); // elle se situera au milieu de la largeur et de la hauteur du canvas
  this.tete = new Tete (x, y, r);

  //on créer également les anneaux
  this.corps = []; //initialement c'est un tableau vide
    for (var i = 0; i < nbAnneaux; i++) {
      x = x - r;
      this.corps[i] = new Anneau(x, y, r); //création du iéme anneau
    }
}

//Objet créer on doit la dessiner
/**----méthode---------*/
  chenille.prototype.dessiner = function(){
    var ctxt = this.canvas.getContext("2d");
    this.tete.dessiner(ctxt);
    for (var i = 0; i < this.corps.length; i++) {
        this.corps[i].dessiner(ctxt);
    }
  };
/** Explication : on veut dessiner la chenille du coup on fait comme précedemment, dans la fonction on créer une variable graphicContext
*comme fait plusieurs fois auparavent
*on dessine la tête avec un dessiner et ctxt en parametre pour dire d'utiliser le graphicContext (un dessin)
*on dessiner le corps de la même maniere avec une boucle selon la longueur du tableau corps toujours avec dessiner et ctxt en parametre
*/
// on doit ensuite la deplacer
  chenille.prototype.deplacer = function(){
    //pour cela c'est simple chaque anneau devra prendre la place du précedent et la tête devra avancer au hasard anneau 0
    for (var i = this.corps.length - 1; i > 0; i--) {
      this.corps[i].placerA(this.corps[i - 1]);
      }
      //la fameuse tête à la position 0
      this.corps[0].placerA(this.tete);
      //deplacement de la tête au hasard un random pour le cap
      this.tete.devierCap(-30.0 + Math.random() * 60.0);
      while (!this.tete.capOK(this.canvas)) {
        this.tete.devierCap(10);//si le cap sort du canvas on lui rajoute 10 degrés pour être sûr qu'il y sera toujours
      }
      //faire avancer dans la direction du cap avec les parametres précedents.
    this.tete.deplacerSelonCap();
  };

/** Tout est en pièce, il ne nous reste plus qu'à invoquer la méthode au chargement de la
page, voyons un peu ça.

//-------Methode-------------//

/** Pour nous remettre les idées au claire, on va énumérer ce qu'ils nous reste à faire :
*On va créer 5 exemplaire de la chenille
*mettre en fonction le bouton startBtn à intervalles réguliers de déplacement
*mettre en fonction le bouton stopBtn pour arrêter les chenilles
*/

function init() { // init conventionnellement initialiser.
  var timerId = 0; //un timer pour l'animation, évidemment initailiser à 0
  var canvas = document.getElementById("Canvas");
  var ctxt = canvas.getContext("2d");
//affichage des objets de la chenille dans leur postition
  var chenilles = [];
  for (var i = 0; i < 15; i++) {
      chenilles[i] = new chenille(canvas, 12, 15);
      chenilles[i].dessiner();
    }
    //association au bouton startBtn qui lance l'animation
  document.getElementById("startBtn").onclick = function() {
    //initialiser leur état en cas de click
    document.getElementById("stopBtn").disabled = false;
    document.getElementById("startBtn").disabled = true;
    //création d'un timer chaque 50 millisecondes et réafficher les chenilles
    timerId = setInterval(function() {
      ctxt.clearRect(0, 0, canvas.width, canvas.height);
      for (var i = 0; i < chenilles.length; i++) {
        chenilles[i].deplacer();
        chenilles[i].dessiner();
      }
    }, 30);
  };

  //associer le bouton stopBtn à l'arrêt
  document.getElementById("stopBtn").onclick = function(){
    //changer leur état en cas de click
    document.getElementById("stopBtn").disabled = true;
    document.getElementById("startBtn").disabled = false;
    //interruption du timer
    clearInterval(timerId);
  };
}

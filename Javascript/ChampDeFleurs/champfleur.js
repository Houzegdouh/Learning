/**
 * Dessine une ellipse dans un canvas
 * @param {CanvasRenderingContext2D} ctx le contexte graphique du canvas
 * @param {number} cx l'abscisse du centre de l'ellipse
 * @param {number} cy l'ordonnée du centre de l'ellipse
 * @param {number} rx le rayon horizontal de l'ellipse
 * @param {number} ry le rayon vertical de l'ellipse
 * @param {number} angle l'angle (en degrés) de l'ellipse par rapport à l'horizontale
 * @param {string} style le style de tracé (couleur) pour le contour de l'ellipse
 */
function ellipse(ctx, cx, cy, rx, ry, angle, style) {
    ctx.save(); // sauvegarde l'état du contexte graphique
    ctx.beginPath();
    ctx.translate(cx, cy);
    ctx.rotate(angle * Math.PI / 180);
    ctx.scale(rx, ry);
    ctx.arc(0, 0, 1, 0, 2 * Math.PI, false);
    ctx.restore(); // restaure l'état original du contexte graphique
    ctx.save();
    if (style) {
        ctx.strokeStyle = style;
    }
    ctx.stroke();
    ctx.restore();
}


function dessinerChFleur() {
console.log("dessinerChFleur");
var nombrefleurs = parseInt(document.getElementById("champfleur").value);
console.log("nombre de fleurs par ligne " + nombrefleurs);
var canvas = document.getElementById("fleurcanvas");
var ctx = canvas.getContext("2d");
var rayon = canvas.width / (2 * nombrefleurs);
var cx = rayon;
var cy = rayon;
ctx.clearRect(0, 0, canvas.width, canvas.height);
for (var  i = 0; i < nombrefleurs; i++) {
 for (var j = 0; j < nombrefleurs; j++) {
 dessinerFleur(ctx, cx, cy, rayon, 'red');
 cx = cx + 2 * rayon;
 }
 cy = cy + 2 * rayon;
 cx = rayon;

    }
}


function dessinerFleur(ctx, cx, cy, rayon, style) {
    var angle = 30;
    for (var i = 0; i < 6 ; i++) {
ellipse(ctx, cx, cy, rayon, rayon / 3, angle, 'red');
        angle += 30;
}
}

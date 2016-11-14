var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
ellipse(ctx,300,300,250,20,0,'orange');
ellipse(ctx,300,300,250,20,15,'green');
ellipse(ctx,300,300,250,20,30,'orange');
ellipse(ctx,300,300,250,20,45,'green');
ellipse(ctx,300,300,250,20,60,'orange');
ellipse(ctx,300,300,250,20,75,'green');
ellipse(ctx,300,300,250,20,90,'orange');
ellipse(ctx,300,300,250,20,105,'green');
ellipse(ctx,300,300,250,20,120,'orange');
ellipse(ctx,300,300,250,20,135,'green');
ellipse(ctx,300,300,250,20,150,'orange');
ellipse(ctx,300,300,250,20,165,'green');
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

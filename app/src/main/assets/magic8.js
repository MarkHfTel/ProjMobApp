// Script für Magic8Ball.html (JG, 2018)
var textAnswersArray = [		
	"It is certain.", 
	"It is decidedly so.", 
	"Without a doubt.", 
	"Yes - definitely.", 
	"You may rely on it.", 
	"As I see it, yes.", 
	"Most likely.", 
	"Outlook good.", 
	"Yes.", 
	"Signs point to yes.", 
	"Reply hazy, try again.", 
	"Ask again later.", 
	"Better not tell you now.", 
	"Cannot predict now.", 
	"Concentrate and ask again.", 
	"Don't count on it.", 
	"My reply is no.", 
	"My sources say no.", 
	"Outlook not so good.", 
	"Very doubtful."
];

var toggler = false;
/**
 *Ein zufälliges Array-Element anzeigen. Word von onClick-Listener (im HTML Code)
 * und vom Keyboard-Event-Listener bei "Enter" (siehe unten) gerufen.
 *Benutzt: 
 * textAnswersArray ... Array der Strings der möglichen Antworten
 * toggler   ... Variable für Wechsel Fragehinweis-Antwort-Anzeige
  */
function nextText()
{
	//amount = textAnswersArray.length;
	//itemNr = Math.floor(Math.random() * amount);			
	//document.getElementById('answerText').innerHTML = textAnswersArray[itemNr] ;
	
	if (toggler == true)
	{
		amount = textAnswersArray.length;
		itemNr = Math.floor(Math.random() * amount);	
		document.getElementById('hintText').innerHTML = "";
		document.getElementById('answerText').innerHTML = textAnswersArray[itemNr] ;
		toggler = false;
	}
	else
	{
		document.getElementById('hintText').innerHTML = "Think a Y/N question<br>... and click!";
		document.getElementById('answerText').innerHTML = "" ;
		toggler = true;
	}
}

// Verarbeite Keyboard-Events ... Hier: Enter Taste neben dem Mausklick verwendbar!
//... siehe: https://developer.mozilla.org/en-US/docs/Web/API/KeyboardEvent
document.addEventListener('keydown', (event) => {
	if(event.key == 'Enter')
		nextText();
}, false);


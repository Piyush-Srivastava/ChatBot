import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.util.Date;
import java.awt.Color;
import java.io.*;
import java.util.*;
import java.lang.*;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;

public class ChatBot extends JFrame implements KeyListener{

	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	// JButton Enter;
	
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);

	
		
	
	String[][] chatBot={
		//standard greetings
		{"hi","hello","hola","ola","howdy"},
		{"hi","hello","hey"},
		//question greetings
		{"how are you","how r you","how r u","how are u"},
		{"good","doing well"},
		//yes
		{"yes"},
		{"no","NO","NO!!!!!!!"},
		//default
		{"shut up","you're bad","noob","stop talking",
		"(michael is unavailable, due to LOL)"}
	};
	
	public static void main(String[] args){
		new ChatBot();
	}
	
	public ChatBot(){
		super("Chat Bot");
		setSize(600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
		
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(255,200,0));
		add(p);

		addText("\n-->Zo\t Hello, I am your virtual assistant Zo. How can i help you?\n");
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say Hello, I am your virtual assistant Zo. How can i help you?";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }
		
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e){

		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			//-----grab quote-----------

			String quote=input.getText();
			input.setText("");
			addText("-->You:\t"+quote);
			quote = quote.toLowerCase();

			if((quote.matches("(.*)how(.*)")&&quote.matches("(.*)you(.*)")))
			{
				// addText("\n-->Zo\t I'm good. Yourself?");
				// try
				// {String[] env = {"PATH=/bin:/usr/bin/"};
				// String cmd = "say I'm good. Yourself?";  
				// Process process = Runtime.getRuntime().exec(cmd, env);
				// }
				// catch(Exception s) {
    //     s.printStackTrace();
    //     }
				try{ 
			File file = new File("resp.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String ln = reader.readLine();
			List<String> lines = new ArrayList<String>();
			while(ln != null){
				lines.add(ln);
				ln = reader.readLine();
			}
			Random r = new Random();
			String text = lines.get(r.nextInt(lines.size()));
			addText("\n-->Zo:\t"+text);
			try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say "+text;  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }
			}catch (IOException t){
			t.printStackTrace();}
			
			}
			if((quote.matches("(.*)tell(.*)")&&quote.matches("(.*)joke(.*)")))
			{
				// addText("\n-->Zo\t I'm good. Yourself?");
				// try
				// {String[] env = {"PATH=/bin:/usr/bin/"};
				// String cmd = "say I'm good. Yourself?";  
				// Process process = Runtime.getRuntime().exec(cmd, env);
				// }
				// catch(Exception s) {
    //     s.printStackTrace();
    //     }
				try{ 
			File file = new File("jokes.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String ln = reader.readLine();
			List<String> lines = new ArrayList<String>();
			while(ln != null){
				lines.add(ln);
				ln = reader.readLine();
			}
			Random r = new Random();
			String text = lines.get(r.nextInt(lines.size()));
			
			addText("\n-->Zo:\t"+text);
			
			try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say "+text;  
				Process process = Runtime.getRuntime().exec(cmd, env);
			}
				catch(Exception s) {
        s.printStackTrace();
        }
    //     	String text2 = lines.get(r.nextInt(lines.size())+1);
    //     	addText("\n-->Zo:\t"+text);
    //     try
				// {String[] env = {"PATH=/bin:/usr/bin/"};
				// String cmd = "say "+text2;  
				// Process process = Runtime.getRuntime().exec(cmd, env);
				// String time = "delay 1";
				// Process process2 =  Runtime.getRuntime().exec(time, env);
				// }
				// catch(Exception s) {
    //     s.printStackTrace();
    //     }
			}catch (IOException t){
			t.printStackTrace();}
			
			}

				else if((quote.matches("(.*)good(.*)")||quote.matches("(.*)fine(.*)"))||(quote.matches("(.*)well(.*)")))
			{
				addText("\n-->Zo\t I'm glad to hear that.");
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say I'm glad to hear that.";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }


    }


			else if((quote.matches("(.*)your(.*)")&&quote.matches("(.*)name(.*)"))||(quote.matches("who are you(.*)")))
			{
				addText("\n-->Zo\t I'm Zo!");
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say I'm Zo";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }


    }

     	else if((quote.matches("(.*)hi(.*)"))||(quote.matches("(.*)hello(.*)"))||(quote.matches("(.*)hey(.*)"))||(quote.matches("yo")))
     	{
     		addText("\n-->Zo\t Hello!");
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say Hello";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        				s.printStackTrace();
        			}
     	}

        	else if((quote.matches("(.*)open(.*)")&&quote.matches("(.*)telegram(.*)")))
			{
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "open /Applications/Telegram.app";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }
    }
        else if((quote.matches("(.*)open(.*)")&&quote.matches("(.*)twitter(.*)")))
			{
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "open /Applications/Twitter.app";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }

			}
			else if((quote.matches("(.*)open(.*)")&&quote.matches("(.*)calendar(.*)")))
			{
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "open /Applications/Calendar.app";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }

			}
			else if((quote.matches("(.*)open(.*)")&&quote.matches("(.*)calculator(.*)")))
			{
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "open /Applications/Calculator.app";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }

			}
			else if((quote.matches("(.*)play(.*)")&&quote.matches("(.*)chess(.*)")))
			{
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "open /Applications/Chess.app";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }

			}


			else if((quote.matches("(.*)your(.*)")&&quote.matches("(.*)name(.*)"))||(quote.matches("who are you(.*)")))
			{
				addText("\n-->Zo\t I'm Zo");
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say I'm Zo";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }


    }

			else if((quote.matches("(.*)play(.*)")&&quote.matches("(.*)music(.*)")))
			{
				addText("\n-->Zo\t Playing music......");
				
				Runtime runtime = Runtime.getRuntime();
                String[] args = {"osascript" , "-e" , "tell application \"iTunes\" to play"};
                try{
                Process process = runtime.exec(args);
                }catch (Exception ex) {                 
                }

			}

			else if((quote.matches("(.*)pause(.*)")&&quote.matches("(.*)music(.*)")))
			{
				
				
				Runtime runtime = Runtime.getRuntime();
                String[] args = {"osascript" , "-e" , "tell application \"iTunes\" to pause"};
                try{
                Process process = runtime.exec(args);
                }catch (Exception ex) {                 
                }

			}

		else if(quote.matches("(.*)who(.*)")||(quote.matches("(.*)created(.*)")&&quote.matches("(.*)you(.*)")))
			{
				addText("\n-->Zo\t I was created by Piyush and Prajesh as a result of open ended project of Java");
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say I was created by Piyush and Prajesh as a result of open ended project of Java";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        				s.printStackTrace();
        			}

			}

		else if((quote.matches("(.*)date(.*)"))||(quote.matches("(.*)time(.*)")))
                      {
                               Date date = new Date();
                               addText("\n-->Michael\t Today's date is: " + date.toString());
                           }

        else if((quote.matches("(.*)weather(.*)"))||(quote.matches("(.*)temperature(.*)")))
        {
        
        	

    //     	try
				// {String[] env = {"PATH=/bin:/usr/bin/"};
				// String url = "wttr.in/india";  
				// String[] command = {"curl", "-H", "Accept:application/json", "-u", url};
				// Process process = Runtime.getRuntime().exec(cmd, env);
				// }
				// catch(Exception s) {
    //     				s.printStackTrace();
    //     			}

        }



			else if((quote.matches("(.*)what can(.*)")))
			{
				addText("\n-->Zo\t Certainly a lot of things!");
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say  Certainly a lot of things!";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        s.printStackTrace();
        }


    }
            else{
            	addText("\n-->Zo\t Sorry! You're expecting too much. I'm still under development.");
				try
				{String[] env = {"PATH=/bin:/usr/bin/"};
				String cmd = "say Sorry! You're expecting too much. I'm still under development.";  
				Process process = Runtime.getRuntime().exec(cmd, env);
				}
				catch(Exception s) {
        				s.printStackTrace();
        			}

            }
                             
            quote.trim();
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			){
				quote=quote.substring(0,quote.length()-1);
			}
			quote.trim();
			byte response=0;
			/*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
			*/
			//-----check for matches----
			// int j=0;//which group we're checking
			// while(response==0){
			// 	if(inArray(quote.toLowerCase(),chatBot[j*2])){
			// 		response=2;
			// 		int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
			// 		addText("\n-->Michael\t"+chatBot[(j*2)+1][r]);
			// 	}
			// 	j++;
				// if(j*2==chatBot.length-1 && response==0){
				// 	response=1;
				// }
			// }
			
			//-----default--------------
			if(response==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\n-->Michael\t"+chatBot[chatBot.length-1][r]);
			}
			addText("\n");
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i=0;i<str.length;i++){
			if(str[i].equals(in)){
				match=true;
			}
		}
		return match;
	}
}
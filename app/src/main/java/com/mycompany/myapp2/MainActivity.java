package com.mycompany.myapp2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.drawable.*;
import android.content.*;

public class MainActivity extends Activity 
{
	private int sdk;
	private int player;
	int [][] matriz = new int[3][3];
	TextView tv, tv1;
	boolean vencedor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		sdk = android.os.Build.VERSION.SDK_INT;
		player = 1;

		tv = (TextView) findViewById(R.id.mainTextView);
		tv1 = (TextView) findViewById(R.id.mainTextViewVencedor);
		tv.setText("Jogador 1");

    }

	public void onClickPlay(View v)
	{
		if (vencedor)
		{return;}
		Drawable background;

		switch (v.getId())
		{
			case R.id.mainView1:
				if (matriz[0][0] != 0)
				{return;}
				matriz[0][0] = player;
				break;
			case R.id.mainView2:
				if (matriz[0][1] != 0)
				{return;}
				matriz[0][1] = player;
				break;
			case R.id.mainView3:
				if (matriz[0][2] != 0)
				{return;}
				matriz[0][2] = player;
				break;
			case R.id.mainView4:
				if (matriz[1][0] != 0)
				{return;}
				matriz[1][0] = player;
				break;
			case R.id.mainView5:
				if (matriz[1][1] != 0)
				{return;}
				matriz[1][1] = player;
				break;
			case R.id.mainView6:
				if (matriz[1][2] != 0)
				{return;}
				matriz[1][2] = player;
				break;
			case R.id.mainView7:
				if (matriz[2][0] != 0)
				{return;}
				matriz[2][0] = player;
				break;
			case R.id.mainView8:
				if (matriz[2][1] != 0)
				{return;}
				matriz[2][1] = player;
				break;
			case R.id.mainView9:
				if (matriz[2][2] != 0)
				{return;}
				matriz[2][2] = player;
				break;
		}

		if (player == 1)
		{
			background = getResources().getDrawable(R.drawable.red);
		}
		else
		{
			background = getResources().getDrawable(R.drawable.blue);
		}

		if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN)
		{
			v.setBackgroundDrawable(background);
		}
		else
		{
			v.setBackground(background);
		}
		verificaCampeao();

		if (player == 2)
		{
			tv.setText("Jogador 1");
			if (vencedor)
			{tv1.setText("Vencedor: Jogador 2");}
		}
		else
		{
			tv.setText("Jogador 2");
			if (vencedor)
			{tv1.setText("Vencedor: Jogador 1");}
		}
		player = player == 1 ? 2 : 1;
	}

	public void verificaCampeao()
	{
		boolean condicao1 = matriz[0][0] != 0 && (matriz[0][0] == matriz[0][1] && 
			matriz[0][1] == matriz[0][2]);

		boolean condicao2 = matriz[1][0] != 0 && (matriz[1][0] == matriz[1][1] && 
			matriz[1][1] == matriz[1][2]);

		boolean condicao3 = matriz[2][0] != 0 && (matriz[2][0] == matriz[2][1] && 
			matriz[2][1] == matriz[2][2]);

		boolean condicao4 = matriz[0][0] != 0 && (matriz[0][0] == matriz[1][0] && 
			matriz[1][0] == matriz[2][0]);

		boolean condicao5 = matriz[0][1] != 0 && (matriz[0][1] == matriz[1][1] && 
			matriz[1][1] == matriz[2][1]);

		boolean condicao6 = matriz[0][2] != 0 && (matriz[0][2] == matriz[1][2] && 
			matriz[1][2] == matriz[2][2]);

		boolean condicao7 = matriz[0][0] != 0 && (matriz[0][0] == matriz[1][1] && 
			matriz[1][1] == matriz[2][2]);

		boolean condicao8 = matriz[2][0] != 0 && (matriz[2][0] == matriz[1][1] && 
			matriz[1][1] == matriz[0][2]);

		if (condicao1 || condicao2 || condicao3 || condicao4 ||
			condicao5 || condicao6 || condicao7 || condicao8)
		{
			vencedor = true;
		}
	}

	public void restartGame(View v)
	{
		for (int i = 1; i <= 9; i++)
		{
			View mainView = findViewById(getResources().getIdentifier("mainView" + Integer.toString(i), "id", getPackageName()));
			if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN)
			{
				mainView.setBackgroundDrawable(getResources().getDrawable(R.drawable.empty));
			}
			else
			{
				mainView.setBackground(getResources().getDrawable(R.drawable.empty));
			}
			player = 1;
			matriz = new int[3][3];
			tv.setText("Jogador 1");
			tv1.setText("");
			vencedor = false;
		}
	}

}

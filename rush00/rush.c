#include <unistd.h>

void ft_putchar(char c)
{
	write(1, &c, 1);
}

void rush(int xc, int yc)
{
	char a;
	char b;
	int x;
	int y;

	a = 'A';
	b = 'B';
	x = 0;
	y = 0;
	while (x < xc)
	{
		while (y < yc)
		{
			if (x == 0 || x == xc - 1)				// первая и последняя строчка
			{
				if (y == 0 || y == yc - 1)
					ft_putchar(a);
				else
					ft_putchar(b);
			}
			else									// внутри 
			{
				if (y == 0 || y == yc - 1)
					ft_putchar(b);
				else
					ft_putchar(' ');
			}
			y++;
		}
		ft_putchar('\n');
		y = 0;
		x++;
	}
}

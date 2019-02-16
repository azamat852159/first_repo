#include <unistd.h>

void	ft_putchar(char c)
{
	write(1, &c, 1);
}

void	rush(int xc, int yc)
{
	int x;
	int y;
	char a;

	a = 176;
	x = 0;
	y = 0;
	while (x < xc - 1)
	{
		while (y < yc - 1)
		{
			if (x == 0 || x == xc - 2)				// первая и последняя строчка
			{
				if (y == 0 || y == yc - 2)
					ft_putchar(a);
				else
					ft_putchar('B');
			}
			else									// внутри 
				if (y == 0 || y == yc - 2)
					ft_putchar('B');
				else
					ft_putchar(' ');
			y++;
		}
		ft_putchar('\n');
		y = 0;
		x++;
	}
}

int main(int kol, char **str)
{
	int x;
	int y;
	int a;
	int b;

	x = 1;
	y = 0;
	if (kol != 3)
	{
		ft_putchar('-');
		return (0);
	}
	while (x < kol)
	{
		while (str[x][y] != '\0')
		{
			if (x == 1)
				a = a * 10 + str[x][y] - 47;
			else 
				b = b * 10 + str[x][y] - 47; 
			y++;
		}
		y = 0;
		x ++;
	}
	rush(a,b);


	return (10);
}


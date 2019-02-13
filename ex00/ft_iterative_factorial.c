/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_iterative_factorial.c                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: uackbar <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/02/02 01:56:42 by uackbar           #+#    #+#             */
/*   Updated: 2019/02/03 04:56:11 by uackbar          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

int	ft_iterative_factorial(int nb);

int	ft_iterative_factorial(int nb)
{
	int c;

	if (nb < 0)
	{
		c = 0;
	}
	if (nb == 0)
	{
		c = 1;
	}
	if (nb > 0)
	{
		c = 1;
		while (nb > 0)
		{
			c = c * nb;
			nb = nb - 1;
		}
	}
	return (c);
}

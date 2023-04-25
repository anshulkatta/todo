import { useState, useEffect } from 'react';

interface FetchResponse<T> {
  data: T[] | null;
  isLoading: boolean;
  error: string | null;
}

export function useFetch<T>(url: string): FetchResponse<T> {
  const [data, setData] = useState<T[] | null>(null);
  const [isLoading, setIsLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      setIsLoading(true);
      try {
        const response = await fetch(url);
        const json = await response.json();
        setData(json);
      } catch (error) {
        setError('Error');
      } finally {
        setIsLoading(false);
      }
    };

    fetchData();
  }, [url]);

  return {
    data,
    isLoading,
    error,
  };
}
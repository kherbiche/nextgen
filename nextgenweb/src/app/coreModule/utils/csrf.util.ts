export abstract class CsrfUtil {

    public static getToken(): string | null {
        return document.querySelector('meta[name="_csrf_token"]')?.getAttribute('content');
    }

    public static getHeaderName(): string | null {
        return document.querySelector('meta[name="_csrf_header_name"]')?.getAttribute('content');
    }

    public static getParameterName(): string | null {
        return document.querySelector('meta[name="_csrf_parameter_name"]')?.getAttribute('content');
    }
}